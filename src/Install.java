import java.io.File;
import java.io.IOException;

import com.sun.source.tree.CatchTree;

public class Install {

	public static void createDir(String baseDir, String dirName) {
		File newDir = new File(baseDir + "/" + dirName);

		if (newDir.mkdir()) {
			System.out.println("Каталог " + baseDir + "/" + newDir.getName() + " создан");
		} else {
			System.out.println("Каталог " + baseDir + "/" + newDir.getName() + " не создан");
		}
	}

	public static void createFile(String baseDir, String fileName) {
		File newFile = new File(baseDir + "/" + fileName);
		try {
			if (newFile.createNewFile()) {
				System.out.println("Файл " + baseDir + "/" + newFile.getName() + " создан");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		String gamesDir = "/home/garrik/Games";
		String baseDir = gamesDir;

		// 1. В папке Games создайте несколько директорий: src, res, savegames, temp.
		createDir(baseDir, "src");
		createDir(baseDir, "res");
		createDir(baseDir, "savegames");
		createDir(baseDir, "temp");

		// 2. В каталоге src создайте две директории: main, test.
		baseDir = gamesDir + "/" + "src";
		createDir(baseDir, "main");
		createDir(baseDir, "test");

		// 3. В подкаталоге main создайте два файла: Main.java, Utils.java.
		baseDir = gamesDir + "/" + "src/main";
		createFile(baseDir, "Main.java");
		createFile(baseDir, "Utils.java");

		// 4. В каталог res создайте три директории: drawables, vectors, icons.
		baseDir = gamesDir + "/" + "res";
		createDir(baseDir, "drawables");
		createDir(baseDir, "vectors");
		createDir(baseDir, "icons");

		// 5. В директории temp создайте файл temp.txt.
		baseDir = gamesDir + "/" + "temp";
		createFile(baseDir, "temp.txt");
	}
}
