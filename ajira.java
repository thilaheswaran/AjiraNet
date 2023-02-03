import java.util.*;

 class network{
   HashMap<String, Integer> device = new HashMap<>();
   HashMap<String, String> con = new HashMap<>();
   List<String> co = new ArrayList<>();
   List<String> re = new ArrayList<>();
  void addDevice(String type,String name)
  {
    if(type.equalsIgnoreCase("computer") || type.equalsIgnoreCase("repeater"))
    {  int x=0;
        for(Map.Entry m : device.entrySet()){    
         if(m.getKey().equals(name))   
         {x++;} 
   }  
        if(x==0)
        {device.put(name, 0);
            con.put(name,"0");
            if(type.equalsIgnoreCase("computer"))
            {
                co.add(name);
            }
            else if(type.equalsIgnoreCase("repeater"))
            {
                re.add(name);
            }
        System.out.println("Successfully added "+name);
        }
        else 
        {System.out.println("Invalid command syntax");}   
    }
    else
    {System.out.println("Invalid command syntax");}

  }
  void setStrength(String name,int s)
  {
   device.put(name,s);
   System.out.println("Successfully defined strength.");
  }
  void connect(String x1,String x2)
  {
     if(!(x1.equalsIgnoreCase(x2))){
      if(!(con.get(x1).equals("0")))
      { con.put(x1,x2);}
      else
      {
        System.out.println("Device is already connected.");
      }
     }
     else{
        System.out.println("Cannot connect device to itself.");
     }
  }
  void routeInfo(String a,String b)
  {
    if(!(re.contains(a) || re.contains(b))){
    if(con.get(a).equalsIgnoreCase(b))
    {
        System.out.println(a +"->"+a);
    }
    
    }
    else
    {
        System.out.println("Router cannot be calculated with a repeater.");
    }
  }
    
}
class ajira
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        network n= new network();
        while(true){
        String a=sc.next();
        String a1=null, a2=null;
        a1=sc.next();
        a2=sc.next();
        if(a.equalsIgnoreCase("Add"))
        {
            n.addDevice(a1, a2);
        }
        else if(a.equalsIgnoreCase("Set_Device_Strength"))
        {
            int s=Integer.parseInt(a2);
            n.setStrength(a1, s);
        }
        else if(a.equalsIgnoreCase("Connect"))
        {
            n.connect(a1, a2);
        }}
    }
}