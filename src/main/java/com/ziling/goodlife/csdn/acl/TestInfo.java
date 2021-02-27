package com.ziling.goodlife.csdn.acl;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestInfo {
    public static void main(String[] args) {
        //System.out.println(1<<35);
        //System.out.println(1<<3);
        TestInfo a = new TestInfo();
        a.swap(5,10);
        //testInfo.placeOneOrZero(2,2);
        //a.findRepeatNum();
        //a.conutOne();
        //a.doubleBinary();
        a.korOneCount();
    }
    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public  static void print(int [] a)
    {
        System.out.println(Arrays.toString(a));
    }
    public void swap(int a, int b)
    {
        a = a^b;
        b = a^b;
        a=  a^b;
        //System.out.println("交换后 a="+a+" b="+b);

    }
    //数字右移到指定第i位，然后再&1
    public static int placeOneOrZero(int num, int i)
    {
        return num >> (i-1) & 1;
    }
    //先把1左移到指定位上，然后在用&判断是否为1，最后再右移回去
    public static int placeOneOrZero2(int num, int i)
    {
        return  (1 <<(i-1)&num) >> (i-1);
    }
    //num>>>31是取最高符号位0或者1，右移1位乘以2，1减去相当于变为-1或者1
    public static int abs(int num){
        return num*(1-((num>>>31) <<1));
    }
    /**
     *   1-1000数放到1001数组中，找出唯一重复的那个数
     *   思路
     *   a^a=0 0^b=b, 如果允许使用辅助空间的话，可以用两个
     *   定义个数组 数组里面随机的放入数
     */
    public void findRepeatNum()
    {
        int N=11;
        //数组里面塞初始值
        int [] num = new int [N];
        for (int i=0; i<N-1; i++)
        {
            num[i] = i+1;
        }
        // 最后一个数，随机数
        num[N-1] = new Random().nextInt(N-1)+1;
        //随机下标
        int index = new Random().nextInt(N);
        //交换num里面的最后一个数和index的数
        TestInfo.swap(num,N-1,index);
        //打印生成的num
        print(num);
        //开始进行主步骤
        int b=0;
        for (int i=0;i<N;i++)
        {
            b=num[i]^b;
        }
        for (int i=1;i<=N-1; i++)
        {
            b=b^(i);
        }
        System.out.println(b);
        System.out.println("=============");
        //开辟个额外的数组空间
        int [] helper = new int [N];
        for (int i=0;i<N;i++)
        {
            helper[num[i]]++;
        }
        for (int i=0;i<N;i++)
        {
            if (helper[i]==2)
            {
                System.out.println(i);
                break;
            }
        }
    }
    /**
     * 输入一个整数，输出二进制表示中1的个数
     * 思路：
     * 1，1和当前整数做&，然后依次的左移
     *2当前数右移（32位）和1&
     * 3.最低位消除1的解法比较特别
     */
    public void conutOne()
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(Integer.toString(N,2));
        //1.对每一位进行与1左移&
        int count = 0;
        for (int i=0; i<32;i++)
        {
            if((N&(1<<i))==(1<<i))
            {
                count++;
            }

        }
        System.out.println(count);//打印思循环的外边
        //2.右移N进行运算
        count=0;
        for (int i=0; i<32;i++)
        {
            if ((N>>>i&1)==1)//注意运算符用0填充高位，防止写错
            {
                count++;
            }

        }
        System.out.println(count);//打印放到循环体外部
        //3. 最低位1消元法换成二进制直接减去1把原N中的低位1变成0
        count = 0;
        while(N!=0)
        {
            N=(N&(N-1));//注意循环迭代条件复制给N
            count++;

        }
        System.out.println(count);//打印放到循环体外部
    }
    /**
     * 一条语句判断一个整数是不是2的整数次方
     * 思路：。转换为二进制数只有一个1.。。。
     * 最复杂的是一直除2除2.一条语句不构
     * 最简单的是参考上一题(N-1)&N是否为0，如果为0则是
     */

    /**
     * 将整数的奇数偶数位互换
     * 思路：笨方法把整数化为Integer.toString(N,2)的字符数
     * 组然后每两位的进行互换，依次递增2
     * 2.位运算
     * abcdefgh &10101010 后右移一位是0a0b0c0d0e0g
     * abcdefgh & 01010101后左移一位是b0d0f0h0
     * 将结果做异或运算得badcfehg
     */
    public int swapOdd(int x)
    {
        int o = x&0xaaaaaaa; //1010 1010 1010....16进制表示
        int j = x&0x55555555; // 01010101......
        return (o>>1)^(j<<1);
    }
    /***
     * 0-1的浮点实数的二进制表示如果二进制的位数多于32位打印ERROR
     * 思路：（0.101的十进制是0.625.是*2扣掉整数
     * 再判断整数位）
     *
     */
    public void doubleBinary()
    {
        double num = 0.456;
        StringBuilder sb = new StringBuilder("0.");
        while(num>0)
        {   //*2挪整
            double r = num*2;
            if(r>=1)//注意是>=情况，用一个变量，防止内存泄漏
            {   sb.append("1");
                num=r-1.0;//-1也可以
            }
            else
            {
                sb.append("0");
                num = r;
            }
        }
        if (sb.length()>34)
        {
            System.out.println("ERROR");
            return;//注意可以用个return语句返回
        }
        System.out.println(sb.toString());
    }

    /**
     * 一个数组中出现了1个一次的和其它数出现了k次找出这个数
     * 思路：暴力解法。直接统计每个数出现次数helper
     * 思路2：2个相同2进制数不进位加法结果0
     *        k个相同的k进制数做不进位加法，结果为0
     *   k是输入进制
     *   先把所有的数转换为K进制，然后进行末尾的不进位加法。
     *   加完后其它的都是0剩下的再还原成原来数
     *
     */
    public void korOneCount()
    {

        int [] num = {3,3,3,5,5,5,6,6,6,11,11,11,9,8,8,8,9,9,9,0,0,0};
        int len = num.length;
        //存放数组的二进制位
        char [][] kbits  = new char[len][];
        int k = 3;//进制可以进行调整，以三为例
        //转换成k进制字符数组对于每个数字\
        int maxLen = 0;
        for(int i=0;i<len;i++) //定义成len的好处
        {
            //求每个数字的三进制字符串并反转，然后转化为字符数组
            kbits[i] = new StringBuilder(Integer.toString(num[i], k)).reverse().toString().toCharArray();
            StringBuilder stringBuilder = new StringBuilder(Integer.toString(num[i], k));
            stringBuilder = stringBuilder.reverse();
            String string = stringBuilder.toString();
            kbits[i] = string.toCharArray();

//            kbits[i] = new StringBuilder(Integer.toString(num[i], k)).reverse().toString().toCharArray();
            if (kbits[i].length > maxLen) //为了获取进制位的最大长度循环用的
            {
                maxLen = kbits[i].length;
            }
        }
        int [] resArr = new int[maxLen];
        //进制不进位加法
        for(int i = 0;i<len;i++)
        {
            for (int j =0;j<maxLen;j++)
            {
                if (j>=kbits[i].length) //对于没有的位数加0处理
                {
                    resArr[j]+=0;
                }
                else
                {
                    resArr[j]+=(kbits[i][j]-'0');//转换成为数字
                }
            }

        }
        //还原为相应的数
        int res = 0;
        for (int i = 0;i<maxLen; i++)
        {
            res+=(resArr[i]%k)*(int)Math.pow(k,i);
        }
        System.out.println(res);
    }
}
