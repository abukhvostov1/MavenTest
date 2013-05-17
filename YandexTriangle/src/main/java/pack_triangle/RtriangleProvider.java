package pack_triangle;

public final class RtriangleProvider
{
	// массив параметров(координаты)
	private static int mas[];
	
	// метод обертка получает объект интерфейса  Rtriangle (просто для удобочитаемости)
	private static Rtriangle GetInterfaceRtriangle(Rtriangle o)
	{
		return o;	
	}
	
	// метод получения координат и переданных в тест параметров
	public static void GetParamsForTest(int masParams[])
	{
		mas = masParams;
	}
	
	// метод из тз возвращает Rtriangle
	public static Rtriangle getRtriangle() 
	{
		Rtriangle k = GetInterfaceRtriangle(new Rtriangle()
		{
			@Override
			public int getApexX1() {
				return mas[0]; 
			}

			@Override
			public int getApexY1() {
				return mas[1];
			}

			@Override
			public int getApexX2() {
				return mas[2];
			}

			@Override
			public int getApexY2() {
				return mas[3];
			}

			@Override
			public int getApexX3() {
				return mas[4];
			}

			@Override
			public int getApexY3() {
				return mas[5];
			}
		}
		);
		return k;

	}
}
