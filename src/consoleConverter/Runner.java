package consoleConverter;

public class Runner
{

	public static void main (String[] args)
	{
		if (args.length!=3)
		{
			System.out.println("Error: Three arguments expected");
			System.exit(1);
		}
		
		String number = args[0];
		int baseFrom;
		int baseTo;
		
//		try
//		{
			try
			{
				baseFrom = Integer.parseInt(args[1]);
				baseTo = Integer.parseInt(args[2]);
			} catch (NumberFormatException e)
			{
				throw new BaseUninterpretableException();
			}
//		} catch (BaseUninterpretableException e)
//		{
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//		}
		
		try
		{
			System.out.println(Converter.convertBase(number, baseFrom, baseTo));
		} catch (NumberUninterpretableException e)
		{
			System.out.println("Exception:" + e.getMessage());
			System.exit(2);
		}catch (BaseOutOfBoundException e)
		{
			System.out.println("Exception:" + e.getMessage());
			System.exit(3);
		}
	}
}

class BaseUninterpretableException extends RuntimeException
{
	public String getMessage()
	{
		return "Base uninterpretable";
	}
}
