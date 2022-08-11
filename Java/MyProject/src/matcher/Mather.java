package matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * group�����()��˵�ģ�group(0)����ָ����������group(1)ָ���ǵ�һ��������Ķ�����group(2)ָ���ǵڶ���������Ķ���
 */
public class Mather {
	public static void main(String[] args) {
		//matherMethod();
		
		matherChar();
	}

	/**
	 * һ��Ԫ�ַ������ض�������ַ�
	 * .  : ƥ������з�����������ַ�
	 * \w : ƥ����ĸ�����ֻ��»���
	 * \s : ƥ������Ŀհ׷�
	 * \d : ƥ������
	 * \b : ƥ�䵥�ʵĿ�ʼ���߽���
	 * ^  : ƥ���ַ����Ŀ�ʼ���ڼ����ַ���[^a]��ʶ�ǡ���ƥ�䡿����˼��
	 * $  : ƥ���ַ����Ľ���
	 * [\\u4E00-\\u9FA5]:ƥ�人��
	 * 
	 * ���������ַ��������ڲ��ҳ�ĳ���ַ���������������ַ������Ե����
	 * \W : ƥ�����ⲻ����ĸ�����ֻ����»��ߵ��ַ�
	 * \S : ƥ�����ⲻ�ǿհ׵��ַ�
	 * \D : ƥ����������ֵ��ַ�
	 * \B : ƥ�䲻�ǵ��ʿ�ͷ�������λ��
	 * [^x]:ƥ�����x����������ַ�
	 * [^aeiou]:ƥ�����aeiou�⼸����ĸ����������ַ�
	 * [^\\u4E00-\\u9FA5]:ƥ�人�ֳ�����ַ�
	 * 
	 * �����޶��ַ����������ظ�ƥ�����
	 * *  : �ظ���λ��߶��
	 * +  : �ظ�һ�λ��߸����
	 * ?  : �ظ���λ���һ��
	 * {n}: �ظ�n��
	 * {n,}:�ظ�n�λ�����
	 * {n,m}:�ظ�n�ε�m��
	 * 
	 * �ġ�ת���ַ����ڿ����Ĺ����У�����ʹ��Ԫ�ַ������ʱ�����Ҫ�����ַ�ת��
	 * Ԫ�ַ�. * \��Ҫת��Ϊ\. \* \\
	 * 
	 * �塢�ַ���֦
	 * �ַ���֦���������㲻ͬ�����ѡ����"|"����ͬ�������ָ��
	 * 
	 * �����ַ����飺���ڽ�����ַ��ظ�����Ҫͨ��ʹ��С����()���з���
	 *   ����			����/�﷨				˵��
	 *   				 (exp)			ƥ��exp,�������ı����Զ�����������
	 *   ����		  (?<name>exp)		ƥ��exp,�������ı�������Ϊname�����Ҳ����д��(?'name'exp)
	 *   				(?:exp)			ƥ��exp,������ƥ����ı���Ҳ�����˷����������
	 *   
	 *  				(?=exp)			ƥ��expǰ���λ��
	 * �������			(?<=exp)		ƥ��exp�����λ��
	 * 					(?!exp)			ƥ����������exp��λ��
	 * 					(?<!exp)		ƥ��ǰ�治��exp��λ��
	 * 
	 *   ע��			(?#comment)		�������͵ķ��鲻���������ʽ�Ĵ��������κ�Ӱ�죬�����ṩע�������Ķ�
	 *   
	 * �ߡ�����ƥ���̰��ƥ��
	 * ̰��ƥ�䣺�������ʽ�а����ظ����޶���ʱ��ͨ������Ϊ�Ǿ����ܶ���ַ�
	 * 
	 * ����ƥ�䣬��ʱ����Ҫƥ�価�����ٵ��ַ�
	 * 
	 * ���磺a.*b��������ƥ�������a��ʼ����b�������ַ������������������aabab�Ļ�������ƥ�������ַ���aabab���������Ǵ�ʱ����
	 * ��Ҫƥ�����ab�����Ļ�����Ҫ�õ�����ƥ���ˡ�����ƥ���ƥ�価�����ٵ��ַ�
	 * ���õ�����ƥ���޶������£�
	 * 
	 *  	����/�﷨					˵��
	 * 		   *? 				�ظ�����Σ������������ظ�
	 * 		   +? 				�ظ�1�λ��߸���Σ������������ظ�
	 *		   ??				�ظ�0�λ�1�Σ������������ظ�
	 *		  {n,m}?			�ظ�n��m�Σ������������ظ�
	 *		   {n,}?			�ظ�n�����ϣ������������ظ�
	 */
	private static void matherChar() {
		String str = "";
		String cstr = "";
		//=========================================Ԫ�ַ�=========================================
		//str = "11 ,2a , 1_ ,"; cstr = "\\d\\w\\s";//ƥ���һ���ַ�Ϊ���֣��ڶ����ַ�Ϊ��ĸ�������֡����»��߻��֣������ַ�Ϊ�ո���ַ���
		//str = "123"; cstr = "^\\d\\d\\d$";//ƥ������ȫ����Ϊ���ֵ��ַ���
		//str = "12345678"; cstr = "^\\d{8}$";//ƥ��8λ���ֵ�qq��
		//str = "I Love Oliver and Olive"; cstr = "\\bOlive\\b";//�����Olive����Ϊ\bƥ����ǵ��ʵĿ�ʼ���߽���
		//str = "���Ǹ�"; cstr = "^[\\u4E00-\\u9FA5]{2,4}$";//ƥ��2~4�������ַ�
		
		//=========================================�����ַ�=========================================
		//str = "1_a��,+-"; cstr = "\\W";//ƥ�����ĸ�����֡��»��ߡ�����������ַ����� +,-
		//str = "ѧ��   ����   ��   ����"; cstr = "\\S";//ƥ����˿ո�����������ַ�
		//str = "abcdefghijk"; cstr = "[^aeiou]";//ƥ�����aeiou�⼸����ĸ����������ַ�
		//str = "���Ǹ�IAMBROTHER"; cstr = "[^\\u4E00-\\u9FA5]";//�����ַ����еķǺ����ַ�
		
		//=========================================�޶��ַ�=========================================
		//str = "(2,3,������)"; cstr = "\\d*";//ƥ���ظ�0�λ��ε����֣�����Ϊ��
		//str = "1,23,234,2345"; cstr = "\\d+";//ƥ���ظ�һ�λ��ε�����
		//str = "(1,2,������)"; cstr = "\\d?";//ƥ���ظ�0�λ���һ�ε����֣�����Ϊ��
		//str = "12345678"; cstr = "\\d{8}";//ƥ���ظ�8������
		//str = "1234,12345,124244"; cstr = "\\d{4,}";//ƥ���ظ�����4������
		//str = "12345678,123456789,1234567890,12345678901"; cstr = "\\d{8,11}";//ƥ���ظ�8-11�ε�����
		
		
		//=========================================ת���ַ�=========================================
		//str = "1900894959@qq.com"; cstr = "\\d{8,}+@+qq+\\.+com";//�������.����Ҫ��б��
		
		//=========================================��֦�ַ�=========================================
		//str = "1523-13883438"; cstr = "\\d{3}-\\d{8}|\\d{4}-\\d{8}";//����ƥ�����ֲ�ͬ�������ŵĹ̶��绰
		
		//=========================================�ַ�����=========================================
		//str = "1a2b3c"; cstr = "(\\d\\w){3}";//ƥ������+��ĸ�����֡��»��ߣ��ظ�ƥ��3��
		/*
		 * �Ȱ�IP��ַ��Ϊ�����֣�һ������123.123.123.��һ������123������Ip���ֵΪ255��������ʹ�÷��飬Ȼ����������ڽ���ѡ��
		 * ������Ҳ�������֣�0-199,200-249,250-255,�ֱ�������ı����Ƕ�Ӧ�����Ҫע�����֮��Ҫ����һ��.,��Ϊ��Ԫ�ַ�����
		 * Ҫת��ʼ���\.Ȼ���ٰ��ⲿ�����忴����һ���飬�ظ����Σ��ټ��Ͻ������ֵ�һ��Ҳ���ǲ�����\.����һ�鼴�����IP��ַ��У��
		 * */
		//str = "192.168.106.75"; cstr="((25[0-5]|2[0-4][0-9]|[0-1]\\d\\d)\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]\\d\\d|\\d\\d)";
		
		//
		
		
		Matcher matcher = Pattern.compile(cstr).matcher(str);
		while(matcher.find()) {
			System.out.println(matcher.group(0));
		}
	}

	private static void matherMethod() {
		String str = "Hello, World! in Java.";
		Pattern pattern = Pattern.compile("W(or)(ld!)");
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()) {
			System.out.println("Group 0:" + matcher.group(0));//�õ���0����--����ƥ��
			System.out.println("Group 1:" + matcher.group(1));//�õ���һ��ƥ��--��(or)ƥ���
			System.out.println("Group 2:" + matcher.group(2));//�õ��ڶ���ƥ��--��(ld!)ƥ��ģ���Ҳ�����ӱ���ʽ
			System.out.println("Start 0:" + matcher.start(0) + " End 0:" + matcher.end(0));//��ƥ�������
			System.out.println("Start 1:" + matcher.start(1) + " End 1:" + matcher.end(1));//��һ��ƥ�������
			System.out.println("Start 2:" + matcher.start(2) + " End 2:" + matcher.end(2));//�ڶ���ƥ�������
			System.out.println(str.substring(matcher.start(0), matcher.end(1)));//����ƥ�俪ʼ��������һ��ƥ��Ľ�������֮����ַ���-Wor
		}
	}
}