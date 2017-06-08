import java.io.*;
public class Bearchairs2
{
    public static int n;
    public static int grt(int ass[],int i)
    {
        int greatest=ass[0];
         System.out.println("in func greatest");
        for(int j=0;j<=i;j++)
        {
            if(greatest<=ass[j])
            greatest=ass[j];
             System.out.println("Great="+greatest);
        }
        return greatest;
    }
    public static int sml(int assi[],int i)
    {
        int smallest=assi[0];
         System.out.println("in func. smallest");
        for(int j=0;j<=i;j++)
        {
            if(smallest>=assi[j])
            smallest=assi[j];
             System.out.println("Small="+smallest);
        }
           return smallest;
    }
    public static int[] findPositions(int atLeast[],int d)
    {
        int assing[]=new int[n];
        int count,i=0;
        int greatest,smallest;
       
        assing[0]=atLeast[0];
        greatest=grt(assing,i);
            smallest=sml(assing,i);
            System.out.println("Out for: Greatest ="+greatest+"for : smallest "+smallest);
            
    for(i=1;i<n;i++)
    {
         System.out.println("i="+i);
        
            greatest=grt(assing,i-1);
            smallest=sml(assing,i-1);
            
             System.out.println("smallest is "+smallest);
              System.out.println("greatest is"+greatest);
        
                    if(atLeast[i]>=greatest)
                    {
                        if(atLeast[i]-greatest<d)
                        assing[i]=greatest+d;
                        else
                        assing[i]=atLeast[i];
                    }
                    else if(atLeast[i]<=smallest)
                    {
                        if(smallest-atLeast[i]>=5)
                        {
                            assing[i]=atLeast[i];
                        }
                        else
                        {
                            
                            for(int i1=0;i1<i;i1++)
                            {
                                int limit=smallest+(2*d);
                                int j1=smallest+1;
                                while(j1<limit)
                                {
                                    
                                    if(assing[i1]==j1)
                                    {
                                    smallest=j1;
                                    j1=smallest;
                                    limit=smallest+(2*d);
                                    }
                                    j1++;
                                }
                                assing[i]=smallest+d;
                            }
                        }
                        
                    }
                    else
                    {
                        System.out.println("loading.....");
                        int flag=0;
                        while(flag==0)
                        {
                        for(int i2=0;i2<i;i2++)
                        {
                            int limit1=smallest+(2*d);
                            int j2=smallest+1;
                            while(j2<limit1)
                            {
                                if(assing[i2]==j2)
                                {
                                smallest=j2;
                                System.out.println("Smallest is now = "+smallest);
                                j2=smallest+1;
                                limit1=smallest+(2*d);
                                i2=0;
                                }
                                else
                                {
                                j2++;
                                }
                            }
                        }
                        
                            if(atLeast[i]-smallest>d)
                            {
                                assing[i]=atLeast[i];
                                flag=1;
                                  if(greatest-atLeast[i]<d)
                                assing[i]=greatest+d;
                            }
                            else
                            {
                                assing[i]=smallest+d;
                                flag=1;
                              
                            }
                        }
                        
                    }
    }
    return assing;
    }
    
    
    public static void main(String args[]) throws IOException
    {
    InputStreamReader a=new InputStreamReader(System.in);
    BufferedReader b=new BufferedReader(a);
    {
       int d;
    System.out.println("Enter the value of N");
    String s=b.readLine();
    n=Integer.parseInt(s);
    System.out.println("Value of D:");
    d=Integer.parseInt(b.readLine());
    int atLeast[]=new int[n];
    int at[]=new int[n];
    for(int i=0;i<=n-1;i++)
    {
        System.out.println("value of table no. for bear"+(i+1));
        atLeast[i]=Integer.parseInt(b.readLine());
    }
    
    
    at=findPositions(atLeast,d);
    System.out.println("The finall array is :");
    for(int j=0;j<=n-1;j++)
    {
        System.out.println(at[j]);
    }
   }
}
}
