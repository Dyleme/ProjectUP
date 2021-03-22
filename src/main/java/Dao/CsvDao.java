package Dao;

import Renatble.OfficeType;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CsvDao<T> extends AbstractDao<T>{

    private final Class<T> tClass;
    private PrintWriter printWriter;
    private Scanner scanner;
    private Scanner lineScanner;

    public CsvDao(String fileName, Class<T> clazz) {
        super(fileName);
        tClass = clazz;
    }

    @Override
    public List<T> read() throws IOException {
        Scanner scanner = new Scanner(new File(fileName));
        List<T> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lineScanner = new Scanner(scanner.nextLine()).useDelimiter(";");
            try {
                list.add((T) readObj(tClass,null));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private Object readObj(Class<?> clazz, Object object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if(clazz.equals(int.class)){
            return lineScanner.nextInt();
        } else if (clazz.equals(boolean.class)){
            return lineScanner.nextBoolean();
        } else if (clazz.equals(String.class)) {
            return lineScanner.next();
        } else if(clazz.equals(OfficeType.class)){
            String string = lineScanner.next();
            return Enum.valueOf(OfficeType.class, string);
        }
//        } else if (clazz.isEnum()) {
//            String string = lineScanner.next();
//            return Enum.valueOf(clazz, string);
//        }
        if (object == null) {
            object = clazz.getConstructor().newInstance();
        }
        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields).sorted();
        if (!clazz.getSuperclass().equals(Object.class)) {
            readObj(clazz.getSuperclass(),object);
        }
        for(Field field : fields){
            String fieldName = field.getName();
            String setterName = new String("set");
            setterName += Character.toUpperCase(fieldName.charAt(0));
            setterName += fieldName.substring(1);
            Method setter = clazz.getMethod(setterName,field.getType());
            Class<?>[] parameterClasses = setter.getParameterTypes();
            setter.invoke(object,readObj(parameterClasses[0], null));
        }
        return object;
    }


    private void writeObj(Object obj, Class<?> clazz) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        if(clazz == int.class){
            printWriter.print((int)obj);
            printWriter.print(';');
        } else if(clazz == boolean.class){
            printWriter.print((boolean) obj);
            printWriter.print(';');
        } else if(clazz == String.class){
            printWriter.print((String) obj);
            printWriter.print(';');
        } else if(clazz == OfficeType.class){
            printWriter.print(((OfficeType)obj).toString());
            printWriter.print(';');
        } else if(obj != null) {
            Field[] fields = clazz.getDeclaredFields();
            if (!clazz.getSuperclass().equals(Object.class)) {
                writeObj(obj, clazz.getSuperclass());
            }
            for(Field field : fields){
                String fieldName = field.getName();
                String getterName = new String("get");
                getterName += Character.toUpperCase(fieldName.charAt(0));
                getterName += fieldName.substring(1);
                Method getter = clazz.getMethod(getterName);
                writeObj(getter.invoke(obj), getter.getReturnType());
            }
        }
    }

    @Override
    public void write(List<T> list) throws IOException {
        printWriter = new PrintWriter(new File(fileName));
        for(T temp : list){
            try {
                writeObj(temp, tClass);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            printWriter.print('\n');
        }
        printWriter.close();
    }
}
