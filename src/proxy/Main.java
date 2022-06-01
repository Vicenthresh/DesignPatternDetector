/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import proxy.Proxy.IClass;
import proxy.Proxy.ProxyClass;

import java.lang.reflect.Method;

import static proxy.PatternRecognizer.isProxy;

/**
 *
 * @author Vicente
 */
public class Main {


    public static void main(String[] args) {
        
        Class proxyClass = Proxy.class;

        if(isProxy(proxyClass)){
            System.out.println("\n" + proxyClass.getCanonicalName() + " has a Proxy pattern");
        }
        else {
            System.out.println(proxyClass.getCanonicalName() + " doesn't have a Proxy pattern");
        }


    }
}
