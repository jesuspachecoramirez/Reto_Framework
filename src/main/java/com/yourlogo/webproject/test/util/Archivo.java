package com.yourlogo.webproject.test.util;

import java.io.File;
import java.nio.file.Path;

public class Archivo {


    public Path subirarchivo(){
        File file = new File("I://Programacion1//Retos//Reto_Framework//src//main//resources//evidence//imagenPrueba.PNG");
        file.toPath();
      return file.toPath();
    }
}
