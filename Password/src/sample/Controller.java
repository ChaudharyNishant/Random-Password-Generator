package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.DataFormat;
import java.util.HashMap;

public class Controller {
    @FXML
    Label password;
    public void GeneratePassword()
    {
        password.setText("");
        int size,i,il,iu,in,is;
        size=12+GenerateRandom(21);
        char[] a = new char[size];
        il=1+GenerateRandom(size-2);
        do
        {
            iu=1+GenerateRandom(size-2);
        }while(iu==il);
        do
        {
            in=1+GenerateRandom(size-2);
        }while(in==iu || in==il);
        do
        {
            is=1+GenerateRandom(size-2);
        }while(is==in || is==iu || is==il);
        for(i=0;i<size;i++)
            a[i]=' ';
        a[0]=(char)(97+GenerateRandom(26));
        a[size-1]=(char)(65+GenerateRandom(26));
        a[il]=(char)(97+GenerateRandom(26));
        a[iu]=(char)(65+GenerateRandom(26));
        a[in]=(char)(48+GenerateRandom(10));
        do
        {
            a[is]=(char)(33+GenerateRandom(94));
        }while((a[is]>='0' && a[is]<='9') || (a[is]>='A' && a[is]<='Z') || (a[is]>='a' && a[is]<='z'));
        for(i=1;i<size-1;i++)
            if(a[i]==' ')
                a[i]=(char)(33+GenerateRandom(94));
        String pass = new String(a);
            password.setText(pass);
    }
    
	public int GenerateRandom(int bound)
    {
        return (System.identityHashCode(new Integer(0)) % bound);
    }

	@FXML
    public void Copy()
    {
        HashMap<DataFormat, Object> map = new HashMap<DataFormat, Object>();
        map.put(DataFormat.PLAIN_TEXT, password.getText());
        Clipboard.getSystemClipboard().setContent(map);
    }
}
