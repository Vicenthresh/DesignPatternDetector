/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

/**
 *
 * @author Vicente
 */
public class Proxy {
    
    public interface IClass {
        void getName();
    }
    
    public class RealClass implements IClass {
    
        private String name;

        public RealClass(String name){
            this.name = name;
        }

        
        public void getName(){
            System.out.println(name);
        }
    }

    public class ProxyClass implements IClass {
        private RealClass realClass;
        private String name;

        public ProxyClass(String name){
            this.name = name;
        }

        
        public void getName() {
            if(realClass == null) realClass = new RealClass(name);

            realClass.getName();
        }
    }
}


    
