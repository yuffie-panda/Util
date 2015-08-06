package com.yuffie.util.thread;

/**
 * 多线程-线程模板
 * 
 * @author Yuffie
 *
 */
public class ThreadTemplate extends Thread {
    
    private Object args;

    public ThreadTemplate(Object args) {

        this.args = args;

    }
    
    public void run() {
        // TODO add function here
    	System.out.println(args);
    	return ;
    }
}