package pack_test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import pack_triangle.Rtriangle;
import pack_triangle.RtriangleProvider;
import pack_triangle.TriangleChecker;
import pack_utils.Print;

@RunWith(Parameterized.class)
public class TestjUnit extends Print
{
	TriangleChecker trChecker; 
	private StringBuffer verificationErrors = new StringBuffer();
	private int masP[];
	
	// конструктор
	public TestjUnit(int x1, int y1, int x2, int y2, int x3, int y3)
	{
		masP = new int[]{x1,y1,x2,y2,x3,y3};
		print("\r\nТест");
		print("Координаты первой точки. X1 = " + x1 + " : Y1 = " + y1);
		print("Координаты второй точки. X2 = " + x2 + " : Y2 = " + y2);
		print("Координаты третей точки. X3 = " + x3 + " : Y3 = " + y3);
	}
	
	// передача параметров (координаты точек)
	@Parameters 
	public static Collection<Object[]> data()
	{
		Object[][] data = new Object[][]
				{
					{ 2,1,2,4,6,1 }, // прямоугольный
					{ 4,5,7,1,6,3 }, // не прямоугольный
					{ 1,2,3,4,5,6 }	 // не прямоугольный	
				};
	    return Arrays.asList(data);
	}

	@Test
	public void test()
	{
		RtriangleProvider.GetParamsForTest(masP);  // передаем координаты из параметров 
		Rtriangle r = RtriangleProvider.getRtriangle(); // получаем объект Rtriangle   
		trChecker = new TriangleChecker(); // создаем объект который будет проверять на треугольник Rtriangle
		trChecker.GetSidesTriangle(r); // получаем длину сторон треугольника Rtriangle
		trChecker.CheckTriangle(); // проверяем с помощью теоремы пифагора
		try
		{
			assertEquals(trChecker.getAb(), trChecker.getC(), 0);   // если квадрат суммы наименьших по длинне сторон не равен квадрату наибольшей стороны то валим тест
		}
		catch (Error e) {verificationErrors.append("Теорема Пифагора не выполняется, объект не является прямоугольным треугольником."); }
		
	}
	
	@After
	public void tearDown() throws Exception
	{ 
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString))
		{
			print("Теорема Пифагора не выполняется, объект не является прямоугольным треугольником.");
			fail(verificationErrorString);
		}
		print("Теорема Пифагора выполняется, объект является прямоугольным треугольником.");
		print("Тест завершен успешно.");
	}

}
