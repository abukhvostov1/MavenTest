package pack_utils;
import java.io.PrintWriter;

// класс правильной проверки обрезки саджестов
public class CutSuggest
{
	public static final int LENGHT = 61;
	
	private static <T> void print(T obj)
	{
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println(obj);
	}
	
	private static String[] print_mass(String[] obj)
	{
		String sT[] = new String[obj.length];
		for(int i=0; i<obj.length; i++)
		{	
			print(obj[i]+" ");
			sT[i] = obj[i]+" ";
		}
		return sT;	
	}
	
	public String GetCutSuggest(String sFullSuggest, String sFindWord)
	{
	
		String sSuggWithAddInfo = sFullSuggest;
		String sSuggest, sAddInfo;
		int l_optim = 0, l_cut = 0, l_sugg = 0;
		String sCh = "... ";
		
		print("\r\nПолный без обрезок саджест с доп. информацией - " + sSuggWithAddInfo);
		String sMas[] = sSuggWithAddInfo.split("\\(");
		sSuggest = sMas[0];
		sAddInfo = "(" + sMas[1];
		print("Длинна саджеста с дополнительной информацией: " + (sSuggest + sAddInfo).length());
		
		// получаем длинну основного саджеста
		String sb_suggest = new String(sSuggest);
		l_sugg = sb_suggest.length();
		print("Длинна необрезанного саджеста: " + l_sugg);
		
		// получаем длинну доп. информации
		String sb_add = new String(sAddInfo);
		print("Длинна дополнительной информации: " + sb_add.length());
		
		// проверяем больше ли длинна саджеста и доп инфы разрешенной длинны (61 символ)
		if((sSuggest+sAddInfo).length() > CutSuggest.LENGHT)
			l_optim = CutSuggest.LENGHT - sb_add.length();
		print("Максимальная возможная длиннна саджеста: " + l_optim);
		
		// количество символов которые надо вырезать
		l_cut = l_sugg - l_optim;
		print("Количество символов необходимых вырезать: " + l_cut);
		
		
		// делим саджест на слова и добавляем пробелы в конце(так как они удаляются при делении) делим
		// что бы узнать есть ли символ знаков прининаний в нашем слове
		String sDivideSuggest[] = sb_suggest.split(" ");
		print("Количество слов в саджесте: " + sDivideSuggest.length);
		print("Слова саджеста");
		sDivideSuggest = print_mass(sDivideSuggest);
		
		int nPos = 1000;
		String sFullFindWord = "";
		
		// проверяем где находится в саджесте искоммое слово и его полное отображение со знаками препининаний (что бы не обрабатывать его)
		for(int i=0; i<sDivideSuggest.length; i++)
		{
			if(sDivideSuggest[i].toLowerCase().contains(sFindWord.toLowerCase()))
			{
				sFullFindWord = sDivideSuggest[i];
				nPos = i;
			}
		}
		print("Полное найденное слово: " + sFullFindWord);
		
		// Если саджест в конце слова	
		if(nPos == sDivideSuggest.length-1)
		{
			print("Искомое слово находится в конце саджеста");
		
			// вырезаем искомое слово  из саджеста
			sSuggest = sSuggest.replaceFirst(sFullFindWord, "");
			print("Саджест после вырезки искомого слова: " + sSuggest);
			
			//вырезаем лишние символы из саджеста
			print("Вырезаем лишние символы из саджеста");
			print("Длинна саджеста с вырезанным искомым словом: " + sSuggest.length());
			sSuggest = sSuggest.substring(0,  sSuggest.length()- l_cut - 4);
			print("Длинна саджеста с вырезанным искомым словом и обрезкой: " + sSuggest.length());
			print("Саджест после вырезки искомого слова и обрезки: " + sSuggest);
			sSuggest += sCh;
			print("Саджест с троеточием:" + sSuggest);
			
			// добавляем искомое слово
			sSuggest += sFullFindWord;
			print("Саджест с троеточием и добавленным искомым словом: " + sSuggest);
			sSuggest += sb_add;
			print("Саджест с троеточием и добавленным искомым словом и доп информацией: " + sSuggest);
			print("Длинна саджеста с троеточием и добавленным искомым словом и доп информацией: " + sSuggest.length());
		}
		if(nPos == 0)
		{
			print("Искомое слово находится в начале саджеста");
			
			// вырезаем искомое слово  из саджеста
			sSuggest = sSuggest.replaceFirst(sFullFindWord, "");
			print("Саджест после вырезки искомого слова: " + sSuggest);
			
			//вырезаем лишние символы из саджеста
			print("Вырезаем лишние символы из саджеста");
			print("Длинна саджеста с вырезанным искомым словом: " + sSuggest.length());
			sSuggest = sSuggest.substring(0,  sSuggest.length()- l_cut - 4);
			print("Длинна саджеста с вырезанным искомым словом и обрезкой: " + sSuggest.length());
			print("Саджест после вырезки искомого слова и обрезки: " + sSuggest);
			sSuggest += sCh;
			print("Саджест с троеточием: " + sSuggest);
			
			// добавляем искомое слово
			sSuggest = sFullFindWord + sSuggest;
			print("Саджест с троеточием и добавленным искомым словом: " + sSuggest);
			sSuggest += sb_add;
			print("Саджест с троеточием и добавленным искомым словом и доп информацией: " + sSuggest);
			print("Длинна саджеста с троеточием и добавленным искомым словом и доп информацией: " + sSuggest.length());	
		}
		if((nPos != 0)&&(nPos != sDivideSuggest.length-1))
		{
			print("Искомое слово находится в середине саджеста");
			print("Разбиваем саджест на две части");
			sDivideSuggest = sSuggest.split(sFullFindWord);
			print("Первая половина саджеста: " + sDivideSuggest[0]);
			print("Вторая половина саджеста: " + sDivideSuggest[1]);
			
			//вырезаем 
			print("Саджест после вырезки искомого слова: " + sDivideSuggest[0]+sDivideSuggest[1]);
			print("Длинна саджеста с вырезанным искомым словом: " + (sDivideSuggest[0]+sDivideSuggest[1]).length());
			print("Из саджеста необходимо вырезать: " + l_cut);
			print("Вырезаем из второй половины");
			// если вторая половина меньше чем то что нам надо вырезать
			if(sDivideSuggest[1].length() < (l_cut+4))
			{
				print("Размер втрой половины саджеста равный " + sDivideSuggest[1].length()+ 
						" меньше чем количество символов которые надо вырезать плюс троеточия, равное " + (l_cut+4));
				print("Заменяем вторую половину троеточием");
				sDivideSuggest[1] = sCh;
				print("Саджест после замены втрой половины троеточием: " + sDivideSuggest[0]+sDivideSuggest[1]);
				print("Длинна саджеста с замененной втрой половиной троеточием: " + (sDivideSuggest[0]+sDivideSuggest[1]).length());
				// если после замены все равно больше(а так и будет) то вырезаем из первой половины
				if((sDivideSuggest[0]+sDivideSuggest[1]+sFullFindWord).length() > l_optim)
				{
					print("Длинна всего саджеста = " + (sDivideSuggest[0]+sDivideSuggest[1]+sFullFindWord).length() + 
							" все равно больше оптимального равного " + l_optim);
					// пересчитываем сколько надо удалить из первой половины
					int lD = (sDivideSuggest[0]+sDivideSuggest[1]+sFullFindWord).length() - l_optim + 4;
					print("Из первой половины надо удалить: " + lD);
					sDivideSuggest[0] = sDivideSuggest[0].substring(0, sDivideSuggest[0].length()-lD);
					sDivideSuggest[0] += sCh;
				}
			}
			else
			{
				print("Размер втрой половины саджеста равный " + sDivideSuggest[1].length()+ 
						" больше чем количество символов которые надо вырезать плюс троеточия, равное " + (l_cut+4));
				print("Обрезаем у второй половины лишние символы");
				sDivideSuggest[1] = sDivideSuggest[1].substring(0, sDivideSuggest[1].length()- l_cut - 4);
				sDivideSuggest[1] += sCh;
			}
			sSuggest = sDivideSuggest[0] + sFullFindWord + sDivideSuggest[1];
			print("Итоговый саджест: " + sSuggest);
			sSuggest += sb_add; 
			print("Саджест с троеточием и добавленным искомым словом и доп информацией: " + sSuggest);
			print("Длинна саджеста с троеточием и добавленным искомым словом и доп информацией: " + sSuggest.length());		
		}
		return sSuggest;
	}
	
}
