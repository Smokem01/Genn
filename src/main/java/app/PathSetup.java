package app;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class PathSetup 
{
	public static void main(String[] args) throws IOException 
    {

		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Choisissez le dossier des Factures: ");
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int returnValue = jfc.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) 
        {
			if (jfc.getSelectedFile().isDirectory()) {
                PrintWriter updater = new PrintWriter(new File("resources\\path.cfg"));
                String r=jfc.getSelectedFile().toString();
                updater.append(r);
                updater.flush();
                updater.close();
			}
		}
	}

}