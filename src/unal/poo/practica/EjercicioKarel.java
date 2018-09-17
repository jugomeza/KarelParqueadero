/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.practica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Estudiante
 */
import becker.robots.*;
import java.awt.Color;
import java.util.Scanner;
import becker.robots.Direction;
import java.util.Arrays;

public class EjercicioKarel {

    private City ciudad;
    private Robot robot;

    int[][] city = new int[7][7];
    int a = 0, b = 0, c = 0, e = 0, x = 0, y = 0, s = 0, k;
    String h = "_";
    String z = null;
    String[] g = new String[15];
    Auto[] car = new Auto[15];
    Thing[] carro = new Thing[15];
    String[][] posicion = new String[7][7];
    Scanner leer = new Scanner(System.in);

    public void girard() {
        robot.turnLeft();
        robot.turnLeft();
        robot.turnLeft();
    }

    public void girara() {
        robot.turnLeft();
        robot.turnLeft();
    }

    public void move1() {
        robot.move();
    }

    public void move2() {
        move1();
        move1();
    }

    public void move3() {
        move2();
        move1();
    }

    public void move4() {
        move3();
        move1();
    }

    public void move5() {
        move4();
        move1();
    }

    public void move6() {
        move5();
        move1();
    }

    public void movec(int b) {
        for (int i = 0; i < b; i++) {
            move1();

        }
    }

    public void espaciomL() {
        a = 0;
        b = 0;
        c = 0;
        s = 0;
        for (int i = 1; i <= 5; i++) {
            switch (i) {
                case 1:
                    for (int j = 0; j < 6; j++) {
                        if (city[j][i] == 1) {
                            a += 1;

                        }

                    }
                    break;
                case 2:
                    for (int j = 0; j < 6; j++) {
                        if (city[j][i] == 1) {
                            b += 1;

                        }
                    }
                    break;
                case 5:
                    for (int j = 0; j < 6; j++) {
                        if (city[j][i] == 1) {
                            s += 1;
                        }

                    }
                case 3:

                    for (int j = 0; j < 6; j++) {
                        if (city[j][i] == 1) {
                            c += 1;

                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void ubicarC1() {
        move1();
        robot.pickThing();
        girara();
        move4();
        girard();
        move1();
        while (robot.canPickThing() == false && robot.frontIsClear() == true) {

            move1();
        }
        if (robot.canPickThing() == true) {
            if (robot.getStreet() == 5 && robot.getAvenue() == 1) {
                girara();
                System.out.println("no hay espacio libre para parquear");
            } else {
                girara();
                move1();
                robot.putThing();
                posicion[robot.getStreet()][robot.getAvenue()] = z;
                city[robot.getStreet()][robot.getAvenue()] = 1;
                espaciomL();

            }
        } else if (robot.getStreet() == 1 && robot.getAvenue() == 1) {
            robot.putThing();
            posicion[robot.getStreet()][robot.getAvenue()] = z;
            city[robot.getStreet()][robot.getAvenue()] = 1;
            espaciomL();

            girara();
        }
        int d = 5 - a;
        movec(d);
        move2();
        robot.turnLeft();
        move3();
    }

    public void ubicarC2() {
        move1();
        robot.pickThing();
        girara();
        move3();
        girard();
        move1();
        while (robot.canPickThing() == false && robot.frontIsClear() == true) {

            move1();
        }
        if (robot.canPickThing() == true) {
            if (robot.getStreet() == 5 && robot.getAvenue() == 2) {
                girara();
                System.out.println("no hay espacio libre para parquear");
            } else {
                girara();
                move1();
                robot.putThing();
                posicion[robot.getStreet()][robot.getAvenue()] = z;
                city[robot.getStreet()][robot.getAvenue()] = 1;
                espaciomL();

            }
        } else if (robot.getStreet() == 1 && robot.getAvenue() == 2) {
            robot.putThing();
            posicion[robot.getStreet()][robot.getAvenue()] = z;
            city[robot.getStreet()][robot.getAvenue()] = 1;
            espaciomL();

            girara();
        }
        int d = 5 - b;
        movec(d);
        move2();
        robot.turnLeft();
        move2();

    }

    public void ubicarC3() {
        move1();
        robot.pickThing();
        girara();
        move2();
        girard();
        move1();
        while (robot.canPickThing() == false && robot.frontIsClear() == true) {

            move1();
        }
        if (robot.canPickThing() == true) {
            if (robot.getStreet() == 5 && robot.getAvenue() == 3) {
                girara();
                System.out.println("no hay espacio libre para parquear");
            } else {
                girara();
                move1();
                robot.putThing();
                posicion[robot.getStreet()][robot.getAvenue()] = z;
                city[robot.getStreet()][robot.getAvenue()] = 1;
                espaciomL();

            }
        } else if (robot.getStreet() == 1 && robot.getAvenue() == 3) {
            robot.putThing();
            posicion[robot.getStreet()][robot.getAvenue()] = z;
            city[robot.getStreet()][robot.getAvenue()] = 1;
            espaciomL();

            girara();
        }

        int d = 5 - c;
        movec(d);
        move2();
        robot.turnLeft();
        move1();
    }

    public void parquear() {
        espaciomL();
        if (a <= b && a <= c) {
            ubicarC1();
        } else if (b < a && b <= c) {
            ubicarC2();

        } else if (c < b) {
            ubicarC3();
        } else {

        }
        e = e + 1;
        espaciomL();
    }

    public void creara() {

        double o;
        if (e < 15) {
            System.out.println("ingrese la placa del vehiculo");
            z = leer.next();
            carro[e] = new Thing(ciudad, 7, 5);
            carro[e].getIcon().setLabel(z);
            g[e] = z;
            car[e] = new Auto();
            car[e].setPlaca(z);
            System.out.println("ingrese su tiempo de ingreso en minutos en el formato de 24 horas");
            o = leer.nextInt();
            car[e].setTingreso(o);

          
        } else {
            System.out.println("no podemos alojar mas vahiculos");
        }
    }

    public void visualizar() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(posicion[i][j]);
                System.out.print(" ");

            }
            System.out.println();

        }
    }

    public void encontrarp() {
        System.out.println("los vehiculos en el parqueadero son:");
        for (int i = 0; i < 15; i++) {
            System.out.print(i + ")" + g[i] + " ");
        }
        System.out.println("");
        System.out.println("ingrese el numero del vehiculo");
        k = leer.nextInt();
        y = 0;
        x = 0;
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                if (posicion[i][j] == g[k]) {
                    System.out.println("su vehiculo se encuentra en la posicion: " + i + "," + j);
                    x = i;
                    y = j;
                }

            }

        }

    }

    public void sacara() {
        espaciomL();
        encontrarp();
        switch (y) {
            case 1:

                girara();
                move3();
                girard();
                move1();

                while (posicion[robot.getStreet()][robot.getAvenue()] != g[k]) {
                    if (robot.getStreet() == 1 && robot.getAvenue() == 1) {
                        System.out.println("el auto no se encuentra en el parqueadero");
                        girara();
                    } else if (robot.canPickThing() == true) {
                        robot.pickThing();
                        city[robot.getStreet()][robot.getAvenue()] = 0;
                        espaciomL();
                        girara();
                        int d = (5 - 1) - a;
                        movec(d);
                        move2();
                        robot.turnLeft();
                        move4();
                        robot.turnLeft();
                        while (robot.canPickThing() == false && robot.frontIsClear() == true) {

                            move1();
                        }
                        if (robot.canPickThing() == true) {
                            if (robot.getStreet() == 5 && robot.getAvenue() == 5) {
                                girara();
                                System.out.println("no hay espacio en el almacen para parquear");
                            } else {
                                girara();
                                move1();
                                robot.putThing();
                                city[robot.getStreet()][robot.getAvenue()] = 1;
                                espaciomL();
                                d = 5  -s;
                                movec(d);
                                move2();
                                girard();
                                move1();
                                move3();
                                girard();
                                move1();

                            }
                        } else if (robot.getStreet() == 1 && robot.getAvenue() == 5) {
                            robot.putThing();
                            city[robot.getStreet()][robot.getAvenue()] = 1;
                            espaciomL();
                            girara();
                            move1();
                            d = (5 -1)- s;
                            movec(d);
                            move2();
                            girard();
                            move1();
                            move3();
                            girard();
                            move1();
                        }
                    } else {
                        move1();
                    }

                }
                robot.pickThing();
                city[robot.getStreet()][robot.getAvenue()] = 0;
                espaciomL();
                girara();
                int d = (5 - 1) - a;
                movec(d);
                move2();
                robot.turnLeft();
                move3();
                robot.putThing();
                System.out.println("ingrese su tiempo de salida en minutos en el formato de 24 horas");
                int t=leer.nextInt();
                car[k].setTsalida(t);
                car[k].instancia();
                System.out.println("su tiempo de instancia es de " + car[k].getTinstancia() + " horas");
                car[k].recibo();
                System.out.println("el valor a cancelar es: " + car[k].getCobro() + "pesos");
                car[k].totali=car[k].totali + car[k].getCobro();

                break;

            case 2:
                girara();
                move2();
                girard();
                move1();
   while (posicion[robot.getStreet()][robot.getAvenue()] != g[k]) {
                    if (robot.getStreet() == 1 && robot.getAvenue() == 2) {
                        System.out.println("el auto no se encuentra en el parqueadero");
                        girara();
                    } else if (robot.canPickThing() == true) {
                        robot.pickThing();
                        city[robot.getStreet()][robot.getAvenue()] = 0;
                        espaciomL();
                        girara();
                         d = (5 - 1) - b;
                        movec(d);
                        move2();
                        robot.turnLeft();
                        move3();
                        robot.turnLeft();
                        while (robot.canPickThing() == false && robot.frontIsClear() == true) {

                            move1();
                        }
                        if (robot.canPickThing() == true) {
                            if (robot.getStreet() == 5 && robot.getAvenue() == 5) {
                                girara();
                                System.out.println("no hay espacio en el almacen para parquear");
                            } else {
                                girara();
                                move1();
                                robot.putThing();
                                city[robot.getStreet()][robot.getAvenue()] = 1;
                                espaciomL();
                                d = 5  -s;
                                movec(d);
                                move2();
                                girard();
                                move1();
                                move2();
                                girard();
                                move1();

                            }
                        } else if (robot.getStreet() == 1 && robot.getAvenue() == 5) {
                            robot.putThing();
                            city[robot.getStreet()][robot.getAvenue()] = 1;
                            espaciomL();
                            girara();
                            move1();
                            d = (5 -1)- s;
                            movec(d);
                            move2();
                            girard();
                            move1();
                            move2();
                            girard();
                            move1();
                        }
                    } else {
                        move1();
                    }

                }
                robot.pickThing();
                city[robot.getStreet()][robot.getAvenue()] = 0;
                espaciomL();
                girara();
                 d = (5 - 1) - b;
                movec(d);
                move2();
                robot.turnLeft();
                move2();
                robot.putThing();
                System.out.println("ingrese su tiempo de salida en minutos en el formato de 24 horas");
                 t=leer.nextInt();
                car[k].setTsalida(t);
                car[k].instancia();
                System.out.println("su tiempo de instancia es de " + car[k].getTinstancia() + " horas");
                car[k].recibo();
                System.out.println("el valor a cancelar es: " + car[k].getCobro() + "pesos");
                car[k].totali=car[k].totali + car[k].getCobro();

                break;
            
            case 3:

                girara();
                move1();
                girard();
                move1();
                while (posicion[robot.getStreet()][robot.getAvenue()] != g[k]) {
                    if (robot.getStreet() == 1 && robot.getAvenue() == 3) {
                        System.out.println("el auto no se encuentra en el parqueadero");
                        girara();
                    } else if (robot.canPickThing() == true) {
                        robot.pickThing();
                        city[robot.getStreet()][robot.getAvenue()] = 0;
                        espaciomL();
                        girara();
                        d = (5 - 1) - c;
                        movec(d);
                        move2();
                        robot.turnLeft();
                        move2();
                        robot.turnLeft();
                        while (robot.canPickThing() == false && robot.frontIsClear() == true) {

                            move1();
                        }
                        if (robot.canPickThing() == true) {
                            if (robot.getStreet() == 5 && robot.getAvenue() == 5) {
                                girara();
                                System.out.println("no hay espacio en el almacen para parquear");
                            } else {
                                girara();
                                move1();
                                robot.putThing();
                                city[robot.getStreet()][robot.getAvenue()] = 1;
                                espaciomL();
                                d = 5  -s;
                                movec(d);
                                move2();
                                girard();
                                move1();
                                move1();
                                girard();
                                move1();

                            }
                        } else if (robot.getStreet() == 1 && robot.getAvenue() == 5) {
                            robot.putThing();
                            city[robot.getStreet()][robot.getAvenue()] = 1;
                            espaciomL();
                            girara();
                            move1();
                            d = (5 -1)- s;
                            movec(d);
                            move2();
                            girard();
                            move1();
                            move1();
                            girard();
                            move1();
                        }
                    } else {
                        move1();
                    }

                }
                robot.pickThing();
                city[robot.getStreet()][robot.getAvenue()] = 0;
                espaciomL();
                girara();
                 d =5- c;
                movec(d);
                move2();
                robot.turnLeft();
                move1();
                robot.putThing();
                System.out.println("ingrese su tiempo de salida en minutos en el formato de 24 horas");
                t=leer.nextInt();
                car[k].setTsalida(t);
                car[k].instancia();
                System.out.println("su tiempo de instancia es de " + car[k].getTinstancia() + " horas");
                car[k].recibo();
                System.out.println("el valor a cancelar es: " + car[k].getCobro() + "pesos");
                car[k].totali=car[k].totali + car[k].getCobro();

                break;


        }
    }

    public void reordenar() {
        espaciomL();
        while (s != 0) {
            move1();
            robot.turnLeft();
            while (robot.canPickThing() == false&&robot.frontIsClear()==true) {
                move1();
            }
            if(robot.getStreet()==1&&robot.getAvenue()==5){
            robot.pickThing();
            city[robot.getStreet()][robot.getAvenue()] = 0;
            girara();
            int d = 5- s;
            movec(d);
            move2();
            robot.putThing();
            girard();
            move1();
            girara();
            parquear();}
            else{ robot.pickThing();
            city[robot.getStreet()][robot.getAvenue()] = 0;
            girara();
            int d = s - 1;
            movec(d);
            move2();
            robot.putThing();
            girard();
            move1();
            girara();
            parquear();}

        }
        espaciomL();
    }

    public void ver() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(" " + city[i][j]);

            }
            System.out.println();
        }
    }
    public void verseccion(){
        System.out.println("ingrese la seccion que desea visualizar ");
        int i=leer.nextInt();
        switch(i){
                case 1:
                    for (int j = 0; j < 6; j++) {
                        System.out.println(posicion[i][j]);}
                break;
                case 2:
                    for (int j = 0; j < 6; j++) {
                        System.out.println(posicion[i][j]);}
                        break;
                case 3: for (int j = 0; j < 6; j++) {
                    System.out.println(posicion[i][j]);}
                break;
                        
                    }
                    }
    
    public void opciones(){
        System.out.println("ingrese la funcion que desea funcion desea realizar: ");
        System.out.println("1; ingresar un auto");
        System.out.println("2; sacar un auto");
        System.out.println("3; visualizar una seccion");
        System.out.println("4; obtener los ingresos del dîa ");
        int v=leer.nextInt();
        switch (v){
            case 1: creara();
                    parquear();
                    break;
            case 2: sacara();
                    reordenar();
                    break;
            case 3: verseccion();
            break;
            case 4: System.out.println(" las ganancias del dia son " + car[0].getTotali() + "pesos");
            break;
        }
    }
                    
    

    public EjercicioKarel() {
        for (String[] row : posicion) {
            Arrays.fill(row, h);
        }
        Scanner leer = new Scanner(System.in);
        this.ciudad = new City();
        for (int i = 1; i <= 7; i++) {
            Wall pared = new Wall(ciudad, 1, i, Direction.NORTH);
        }
        for (int i = 1; i <= 7; i++) {
            Wall pared = new Wall(ciudad, i, 1, Direction.WEST);
        }
        for (int i = 1; i <= 3; i++) {
            Wall pared = new Wall(ciudad, 7, i, Direction.SOUTH);
        }
        for (int i = 6; i <= 7; i++) {
            Wall pared = new Wall(ciudad, 7, i, Direction.SOUTH);
        }
        for (int i = 1; i <= 7; i++) {
            Wall pared = new Wall(ciudad, i, 7, Direction.EAST);
        }
        for (int i = 1; i <= 5; i++) {
            Wall pared = new Wall(ciudad, i, 1, Direction.EAST);
        }
        for (int i = 1; i <= 5; i++) {
            Wall pared = new Wall(ciudad, i, 2, Direction.EAST);
        }
        for (int i = 1; i <= 5; i++) {
            Wall pared = new Wall(ciudad, i, 3, Direction.EAST);
        }

        robot = new Robot(ciudad, 7, 4, Direction.EAST);
        
        for (int i = 0; i < 31; i++) {
            opciones();
            
        }

    }
}
