package util;

/**
 * 算法工具类，练习算法。通过SuanfaTest来测试
 * @author by 邻居的耳朵
 * @Begin 2017/9/21.
 */

import static java.lang.Math.sqrt;

public class SuanFa {
    /**
     * 1. 斐波拉契--古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
     小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少
     */
    public int countRabbit(int n){
        //递归来实现。递归的关键是找准出口，但是递归太占内存，效率不高。数量太大时不建议使用
        if(n==1||n==2){
            return 1;
        }else{
            return countRabbit(n-1)+countRabbit(n-2);
        }
    }
    /**
     * 2.判断101-200之间有多少个素数，并输出所有素数。
     */
    public void primeNum(int start,int end){
        int count=0;   //统计start,end之间的素数个数。
        if(start>end){   //保证start小于end
            System.out.println("传入数据有误！");
            return;
        }
        for(int i=start;i<=end;i++){
            boolean flag=true;  //素数标志，默认为true。
            //素数的定义，除1外，只能被本身整除的数
            for(int j=2;j<i;j++){
                if(i%j==0){         //满足整除则为false，2由于不能进入循环因而还是true
                    flag=false;
                }
            }
            if(flag){
                count++;
                System.out.print(i+"\t");
                if(count%15==0)      //每15个则换行
                    System.out.println();
            }
        }
        System.out.println("\n"+"-----------------****************-------------------");
        System.out.println(start+"到"+end+" 共有"+count+" 个素数");
    }
    /**
     * 2.素数实现方法二：用一个数分别去除2到sqrt(这个数)，如果能被整除，则表明此数不是素数，反之是素数
     */
    public  boolean isPrime(int num) {
        boolean flag = true; //默认是素数
        if(num<=1)
            flag=false;
        for(int i=2;i<=sqrt(num);i++){
            if(num%i==0){
                flag=false;
            }
        }
        return  flag;
    }
    /**
     * 3.打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
     */
    public void lotusNum(int n){
        if(n<=100){
            System.out.println("输入有误！");
        }
        //关键是拆分出个十百位
        int ge,shi,bai;
        for(int i=100;i<=n;i++){
            ge=i%10;
            shi=i/10%10;
            bai=i/10/10%10;
            double d=Math.pow(ge,3)+ Math.pow(shi,3)+Math.pow(bai,3);
            if(d==i){
                System.out.print(i+"\t");
            }
        }
    }
    /**
     * 4. 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
     */
    public void showDepose(int n){
        if(n<=0){
            System.out.println("输入有误！");
        }
       /*
       程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
     (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
     (2)如果n<>k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数n,重复执行第一步。
     (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步
        */
        if(n==1||n==2){
            System.out.println(n+"="+1*n);
        }
        //// TODO: 2017/9/21   还不会啊
        for(int i=2;i<n;i++){
            while(n%i==0 && n!=i){
                n/=i;
                System.out.print(i+"*");
            }
            if(n==i){
                System.out.println(i);
                break;
            }
        }
    }
}

