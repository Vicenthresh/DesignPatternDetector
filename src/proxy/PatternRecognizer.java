package proxy;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class PatternRecognizer {

    public static boolean isProxy(Class c) {
        Class[] classes = c.getClasses();
        String interfaceMethod = "";
        String interfaceName = "";

        for(Class cl : classes){
            // Check if there is an interface
            if(cl.isInterface()){
                interfaceName = cl.getName();
                interfaceMethod = cl.getDeclaredMethods()[0].getName();

                System.out.println("Interface name: " + interfaceName);
                System.out.println("Interface method: " + interfaceMethod);
            }
            // Check if the classes implement the same interface
            else if(cl.getInterfaces()[0].getName().equals(interfaceName))
                return false;
        }

        // If there isn't an abstract class, it's not Proxy
        if(interfaceMethod.equals(""))
            return false;


        for(Class cl : classes){
            System.out.println("Class name:" + cl.getCanonicalName());
            Method[] methods = cl.getDeclaredMethods();
            // Check if the methods are the same
            for(Method m : methods)
                if (!interfaceMethod.equals(m.getName())) return false;
        }
        return true;
    }

    public static boolean isFacade(Class c){
        Class[] classes = c.getClasses();

        for (Class cl : classes){

        }
        return true;
    }
    public static boolean ClaseSingleton(Class clase){
        // Obtener Metodos
        Method[] methods = clase.getDeclaredMethods();
        try { // se intenta obtener el constructor
            System.out.println("El constructor " + clase.getConstructor().getName() + " es publico");
            return false;
        } catch (NoSuchMethodException e) {
            System.out.println("\nConstructor Privado, Clase: "+clase.getName());
        }
        for(Method m : methods){
            // Se comprueba si el retorno es del tipo de la clase
            if (!m.getAnnotatedReturnType().toString().equals(clase.getName())) return false;
        }
        return true;
    }
    public static boolean isSingleton(Class c){
        // Comprueba si alguna clase es Singleton
        Class[] clases = c.getClasses();
        for (Class clase : clases)
            if(ClaseSingleton(clase)) return  true;
        return false;
    }
}
