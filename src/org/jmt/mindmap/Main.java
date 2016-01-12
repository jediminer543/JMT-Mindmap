package org.jmt.mindmap;

import static org.lwjgl.opengl.GL.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.nanovg.NanoVG.*;
import static org.lwjgl.nanovg.NanoVGGL2.*;

import java.lang.reflect.Field;

import org.lwjgl.nanovg.NVGColor;

public class Main {

	
	static int resX = 1600, resY = 900;
	static long window;
	static long vg;
	//static ArrayList<Long> windows = new ArrayList<>();
	
	public static void main(String[] args) {
		setNativePath("lib/native");
		
		if(glfwInit() != GLFW_TRUE) {
			return;
		}
		
		//windows.add(glfwCreateWindow(resX, resY, "Mindmap", 0, 0));
		window = glfwCreateWindow(resX, resY, "Mindmap", 0, 0);
		glfwMakeContextCurrent(window);
		
		createCapabilities();
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glFrustum(0, resX, resY, 0, 0.01f, 10f);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		vg = nvgCreateGL2(NVG_ANTIALIAS | NVG_STENCIL_STROKES | NVG_DEBUG);
		
		while (GLFW_TRUE != glfwWindowShouldClose(window)) {
			glLoadIdentity();
			glClear(GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT);
			
			glfwPollEvents();
			glfwSwapBuffers(window);
			
			nvgBeginFrame(vg, resX, resY, resX/resY);
			nvgRect(vg, 10, 10, 10, 10);
			nvgFillColor(vg, rgba(245, 130, 30, 255, NVGColor.create()));
			nvgFill(vg);
			nvgEndFrame(vg);
		}
	}
	
	static NVGColor rgba(int r, int g, int b, int a, NVGColor color) {
		color.r(r / 255.0f);
		color.g(g / 255.0f);
		color.b(b / 255.0f);
		color.a(a / 255.0f);

		return color;
	}
	
	public static void setNativePath(String path) {
		System.setProperty( "java.library.path", path);
		 
		Field fieldSysPath;
		try {
			fieldSysPath = ClassLoader.class.getDeclaredField( "sys_paths" );
			fieldSysPath.setAccessible( true );
			fieldSysPath.set( null, null );
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
