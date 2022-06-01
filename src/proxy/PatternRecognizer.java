package proxy;

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
            else {
                if(cl.getInterfaces()[0].getName().equals(interfaceName)){
                    return false;
                }
            }
        }

        // If there isn't an abstract class, it's not Proxy
        if(interfaceMethod.equals("")){
            return false;
        }

        for(Class cl : classes){
            System.out.println("Class name:" + cl.getCanonicalName());

            Method[] methods = cl.getDeclaredMethods();

            // Check if the methods are the same
            for(Method m : methods) {
                if (interfaceMethod.equals(m.getName())) {
                    interfaceMethod = m.getName();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isFacade(Class c){
        Class[] classes = c.getClasses();

        for (Class cl : classes){

        }
        return true;
    }
}
