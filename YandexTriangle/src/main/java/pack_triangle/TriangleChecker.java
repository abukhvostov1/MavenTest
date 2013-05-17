package pack_triangle;

import java.util.ArrayList;
import java.util.Collections;


import pack_utils.Comp;
import pack_utils.Print;

// класс выполняющий проверку объекта возвращаемого методом getRtriangle() класса  RtriangleProvider
public class TriangleChecker extends Print
{

	// здесь храним длинну каждой стороны треугольника
	private ArrayList<Double> list = new ArrayList<Double>();
	private double ab; // квадрат суммы двух сторон (меньших) (катеты)
	private double c; // квадрат третей стороны (гипотенуза)

	// гетеры и сеттеры для квадратов сторон ab и c
	public double getAb(){return ab;}

	public void setAb(double ab){this.ab = ab;}

	public double getC(){return c;}

	public void setC(double c){this.c = c;}

	// геттер списка
	public ArrayList<Double> GetList(){return list;}
	
	// получение длины первой строны треугольника
	private double GetSideOne(Rtriangle r)
	{
		print("Получаем длинну первой стороны");
		double a = Math.pow( (r.getApexX1()-r.getApexX2()) ,2);
		double b = Math.pow( (r.getApexY1()-r.getApexY2()), 2);
		double c = Math.sqrt(a  +  b);
		print("Длинна стороны один (координаты {X1,Y1}-{X2,Y2}) равна: " + c);
		return c;
	}
	
	// получение длины второй строны треугольника
	private double GetSideTwo(Rtriangle r)
	{
		print("Получаем длинну второй стороны");
		double a = Math.pow( (r.getApexX2()-r.getApexX3()) ,2);
		double b = Math.pow( (r.getApexY2()-r.getApexY3()), 2);
		double c = Math.sqrt(a  +  b);
		print("Длинна стороны два (координаты {X2,Y2}-{X3,Y3}) равна: " + c);
		return c;
	}
	
	// получение длины третей строны треугольника
	private double GetSideThree(Rtriangle r)
	{
		print("Получаем длинну третей стороны");
		double a = Math.pow( (r.getApexX3()-r.getApexX1()) ,2);
		double b = Math.pow( (r.getApexY3()-r.getApexY1()), 2);
		double c = Math.sqrt(a  +  b);
		print("Длинна стороны три (координаты {X3,Y3}-{X1,Y1}) равна: " + c);
		return c;
	}
	
	// получение длины каждой стороны треугольника и добавления его в список и последующая сортировка в порядке возврастания сторон
	public void GetSidesTriangle(Rtriangle r)
	{
		list.add(GetSideOne(r)); 
		list.add(GetSideTwo(r));
		list.add(GetSideThree(r));
		Collections.sort(list, new Comp<Double>()); // сортируем стороны в списке в порядке возврастания
	}
	
	// провера треугольника с помощью теоремы пифагора c^2=a^2+b^2 где с - наибольшая сторона, если это равенство выполняется то треугольник прямоугольный
	public void CheckTriangle()
	{
		print("Проверяем треугольник с помощью теоремы Пифагора");
		double ab1 =( Math.pow(list.get(0), 2) +  Math.pow(list.get(1), 2) );
		double c1 = Math.pow(list.get(2), 2);
		print("Квадрат суммы двух сторон равен:" + ab1);
		print("Квадрат третей стороны равен:" + c1);
		setAb(ab1);
		setC(c1);
	}
	
	

}



