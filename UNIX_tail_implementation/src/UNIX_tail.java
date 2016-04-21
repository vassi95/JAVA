import java.io.*;
import java.util.HashMap;

public class UNIX_tail {
	public void tail(String filename, long n) {
		HashMap<Long, String> m = new HashMap<Long, String>();
		long numberOfLines = Long.valueOf(n).longValue();
		try {
			RandomAccessFile file = new RandomAccessFile(filename, "r");
			long filelength = file.length();
			long pos = filelength - 1;
			for (long i = 1; i <= numberOfLines; pos--) {
				file.seek(pos);
				if (file.readByte() == 0xA)
					if (pos == filelength - 1)
						continue;
					else {
						m.put(i, file.readLine());
						i++;
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		long startPosition = numberOfLines;
		while (startPosition != 0) {
			if (m.containsKey(startPosition)) {
				String outstr = (String) m.get(startPosition);
				System.out.println(outstr);
				startPosition--;

			}
		}
	}
}
