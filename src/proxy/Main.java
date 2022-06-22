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
import static proxy.filechooser.createAndShowGUI;

/**
 *
 * @author Vicente
 */
public class Main {


    public static void main(String[] args) {
        createAndShowGUI();
    }
}
