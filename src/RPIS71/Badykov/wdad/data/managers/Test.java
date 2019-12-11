package RPIS71.Badykov.wdad.data.managers;

public class Test {
    public static void main(String[] args) {
        PreferencesManager manager = PreferencesManager.INSTANCE;
        manager.setCreateRegistry("yes");
        System.out.println(manager.getCreateRegistry());
        manager.setCreateRegistry("no");
        System.out.println(manager.getCreateRegistry());
    }
}
