package src;

public class ConsoleHelper implements Runnable {
    private String lastLine = "";

    public void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (int i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1)
                System.out.print("\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }

    private int anim = 0;

    public void animate(String line) {
        switch (anim) {
            case 1:
                print(line + " [ ..    ]");
                break;
            case 2:
                print(line + " [ ...   ]");
                break;
            case 3:
                print(line + " [ ....  ]");
                break;
            case 4:
                print(line + " [ ..... ]");
                break;
            default:
                anim = 0;
                print(line + " [ .     ]");
                break;
        }
        anim++;
    }


    public void run(){
        try {
            while(!Main.isDone) {
                animate("Calcul en cours   ");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}