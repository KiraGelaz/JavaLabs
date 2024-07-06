public class Main {
    public static void main(String[] args) {
        Sync sync = new Sync();
        sync.sync = 0;

        AbstractClass abstractProgram = new AbstractClass(AbstractClass.status.UNKNOWN, sync);
        Thread threadForAbsProgram = new Thread(abstractProgram);
        threadForAbsProgram.start();

        Supervisor supervisor = new Supervisor(abstractProgram, sync);
        Thread threadForSupervisor = new Thread(supervisor);
        threadForSupervisor.start();


    }
}