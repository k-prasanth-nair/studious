package com.dp.singleton;

/**
 * Created by prasanth on 12/3/16.
 */
public class Example2 {

    public static void main(String s[]){

        System.out.println( EnumSingleton.INSTANCE.getString() );
        System.out.println( EnumSingleton.INSTANCE.getString() );


        // Runtime it will fail
       // EnumSingleton.INSTANCE.equals( Level.HIGH );

        // Always compare using ==
        // EnumSingleton.INSTANCE ==   Level.HIGH

    }

    /**
     *
     * Thread safe
     * Guaranteed one instance (Cannot instantiate more then one enum even through reflection.)
     * Takes care of Serialization
     *
     */

    //internally inherits lang.Enum class implicitly
    public enum EnumSingleton{
        INSTANCE;

        private String MY_STRING ;

        //cannot use public or protected
        private EnumSingleton(){
            System.out.println("Inside");
            MY_STRING = "Hello";
        }

        public String getString(){
            return MY_STRING;
        }

    }

    //internally inherits lang.Enum class implicitly

    /**
     *
     *
     *  Enums can be used in TreeSet and TreeMap since it implements Comparable
     *
     *  compareTo methods use ordinal to compare
     *
     */
    public enum Level{
        HIGH(1){
            public String color(){
                return "red";
            }

        },

        MEDIUM(2){

            public String color(){
                return "Yellow";
            }
        },

        LOW(3){
            public String color(){
                return "Green";
            }
        };

        private int code ;

        //cannot use public or protected
        private Level(int code){
            code = code;
        }

        public int getLevelCode(){
            return code;
        }

        public abstract String color();

    }
}
