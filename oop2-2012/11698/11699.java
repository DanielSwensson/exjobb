import java.awt.*;
public class Background implements Drawable
{
    int p1Score, p2Score, screenWidth;
    Font font;

    public Background(int screenWidth){
        this.screenWidth=screenWidth;
        font = new Font("System", Font.PLAIN, 30);

    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 10000, 10000);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(""+(p1Score),screenWidth/10,100);//placering av score
        g.drawString(""+(p2Score),screenWidth-screenWidth/10,100);//placering av score
    }

    public void addScore(int player){
        if (player==1){
            p1Score++;
        }else {
            p2Score++;
        }

    }
}
