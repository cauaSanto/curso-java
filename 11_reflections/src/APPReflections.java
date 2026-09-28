import java.lang.reflect.*;
//aula 93
public class APPReflections {

    static void main(String[] args) {
        Class clazz = Produto.class;
        System.out.println(clazz);

        Produto prod = new Produto();
        Class clazz1 = prod.getClass();
        System.out.println(clazz1);

        try {
            System.out.println("Constructors");

            Constructor cons = clazz.getConstructor();
            Produto prod1 = (Produto) cons.newInstance();
            System.out.println(cons);
            System.out.println(prod1);

            Field[] fields =  prod1.getClass().getDeclaredFields();

            System.out.println("fields");

            for(Field field : fields){
                Class<?> type =  field.getType();
                String nome = field.getName();
                System.out.println(type);
                System.out.println(nome);
            }

            System.out.println("Methods");

            Method[] methods = prod1.getClass().getDeclaredMethods();
            for(Method m : methods){
                Class<?> type =  m.getReturnType();
                String nome = m.getName();
                System.out.println(type);
                System.out.println(nome);

                System.out.println("excutando métodos");

                if(m.getName().startsWith("get")){
                    System.out.println(m.invoke(prod1));
                }else{
                    for(Class classesTypes : m.getParameterTypes()){
                        if(classesTypes.equals(String.class)) {
                            System.out.println(m.invoke(prod1, "Rodrigo"));
                        }else if(classesTypes.equals(Long.class)){
                            System.out.println(m.invoke(prod1, 1l));
                        }else{
                            System.out.println(m.invoke(prod1, 2d));
                        }
                    }


                }
            }

        }catch (NoSuchMethodException | InstantiationException| IllegalAccessException| IllegalArgumentException| InvocationTargetException e){
            e.printStackTrace();
        }

    }
}
