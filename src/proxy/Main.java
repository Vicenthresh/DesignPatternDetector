/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import proxy.Proxy.*;
import proxy.Singleton.*;
import java.lang.reflect.Method;

import static proxy.PatternRecognizer.isProxy;
import static proxy.PatternRecognizer.isSingleton;

/**
 *
 * @author Vicente
 */
public class Main {


    public static void main(String[] args) {
        
        Class proxyClass = Proxy.class;
        Class SingletonClass = Singleton.class;
        System.out.println("\nProxy pattern\n");
        if(isProxy(proxyClass)){
            System.out.println("\n" + proxyClass.getCanonicalName() + " has a Proxy pattern");
        }
        else {
            System.out.println(proxyClass.getCanonicalName() + " doesn't have a Proxy pattern");
        }
        System.out.println("\nSingleton pattern\n");
        if(isSingleton(SingletonClass))
            System.out.println("\n" + SingletonClass.getCanonicalName() + " has a Singleton pattern");
        else
            System.out.println(SingletonClass.getCanonicalName() + " doesn't have a Singleton pattern");
    }
}
