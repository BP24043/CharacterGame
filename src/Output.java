public class Output {

    public void printSystem(String message){
        System.out.println(message);
    }

    public void printCharacter(String message){
        System.out.println(DataLoader.getInstance().getUserName() + "「" + message + "」");
    }
}
