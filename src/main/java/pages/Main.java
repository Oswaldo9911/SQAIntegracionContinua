package pages;


import pages.*;
import java.util.ArrayList;
import java.util.List;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Oswaldo Buitrago SQA S.A - fabio.betancourt@sqasa.com
 */

public class Main {

    public static void main(String[] args) {
        List<String> file = new ArrayList<String>();
        file.add(System.getProperty("user.dir") + "\\TestNG.xml");
        TestNG testNG = new TestNG();
        testNG.setTestSuites(file);
        testNG.run();
    }
}
