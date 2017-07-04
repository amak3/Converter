package consoleConverter;

public class Converter
{		
	public static Boolean isBaseValid(int base)
	{
		return (base == 2 || base == 3 || base == 7 || base == 8 || base == 10 || base == 12 ||base == 16);
	}
	public static String convertBase(String number, int baseFrom, int baseTo)
	{
					
		if (!isBaseValid(baseFrom))
		{
			throw new BaseOutOfBoundException();
		}
		if (!isBaseValid(baseTo))
		{
			throw new BaseOutOfBoundException();
		}
			
		
			try
			{
				int a = Integer.parseInt(number, baseFrom);
				return Integer.toString(a, baseTo);
			} catch (NumberFormatException e)
			{
				throw new NumberUninterpretableException();
			}
		
	}
}	
	class NumberUninterpretableException extends RuntimeException
	{
		public String getMessage()
		{
			return "Number uninterpretable";
		}
	}

	class BaseOutOfBoundException extends RuntimeException
	{
		public String getMessage()
		{
			return "Base out of bound";
		}
	}
