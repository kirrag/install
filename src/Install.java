import java.io.File;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.FileWriter;

public class Install {

	public static StringBuilder log = new StringBuilder();

	public static String getDate(Date date) {
		String strDate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(date);
		return strDate;
	}

	public static void createDir(String baseDir, String dirName) {
		File newDir = new File(baseDir + "/" + dirName);
		String DirPathStr = " Каталог \"" + baseDir + "/" + newDir.getName() + "\"";
		if (newDir.mkdir()) {
			log.append(getDate(new Date()) + DirPathStr + " создан\n");
		} else {
			if (newDir.exists()) {
				log.append(getDate(new Date()) + DirPathStr + " уже существует\n");
			} else {
				log.append(getDate(new Date()) + DirPathStr + " не создан\n");
			}
		}
	}

	public static void createFile(String baseDir, String fileName) {
		File newFile = new File(baseDir + "/" + fileName);
		String FilePathStr = " Файл \"" + baseDir + "/" + newFile.getName() + "\"";
		try {
			if (newFile.exists()) {
				log.append(getDate(new Date()) + FilePathStr + " файл уже существует\n");
			} else {
				newFile.createNewFile();
				log.append(getDate(new Date()) + FilePathStr + " создан\n");
			}
		} catch (IOException e) {
			log.append(getDate(new Date()) + FilePathStr + " не создан: " + e.getMessage() + "\n");
		}
	}

	public static void main(String[] args) {
		String gamesDir = "/home/garrik/Games/GunRunner";
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
		
		// Запись логов
		try (FileWriter fw = new FileWriter(baseDir + "/temp.txt", true)) {
			fw.write(log.toString());
			fw.flush();
			System.out.println("Лог создан: " + baseDir + "/temp.txt");
		} catch (IOException e) {
			System.out.println("Лог не создан " + e.getMessage());
		}
	}
}
