package com.dp.template;

/**
 * Created by prasanth on 12/3/16.
 */


/**
 *
 * Just focus on the abstraction that is Develop and code
 *
 * We will take care of the specific steps in dervied class , just provide the class *
 *
 * Used in web frameworks
 *
 *
 * Pros:
 *
 * When focus on major step as client and  all you care about is all steps are being performed. We dont care about what the steps are , but all steps needs to be done
 *
 *
 * Cons:
 *
 * We cannot change/vary the steps. For eg if we need to include build instead of compile or if we need to change the unit testing how can we achieve
 *
 * This can be achieved by  CReating Different Classes DevelopJavaCodeWithMaven, DevelopJavaCodeWithGradle etc...But this is really not a good design because
 *
 * We violate DRY principle .. cause we end up duplicating and also results in lot of Classes
 *
 * This is overcomed by Strategy
 *
 *
 */
public class TemplateMethod {

    public static void work(Develop develop){
        develop.code();
    }


    public static void main(String[] args) {
        work(new DevelopJavaCode());
        work(new DevelopCSCode());
    }
}
