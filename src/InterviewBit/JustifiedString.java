package InterviewBit;

import java.util.ArrayList;

public class JustifiedString {
	public static ArrayList<String> fullJustify(ArrayList<String> words, int L) {
		ArrayList<String> lines = new ArrayList<>();

		int index = 0;
		while (index < words.size()) {
			int count = words.get(index).length();
			int last = index + 1;
			while (last < words.size()) {
				if (words.get(last).length() + count + 1 > L)
					break;
				count += words.get(last).length() + 1;
				last++;
			}

			StringBuilder builder = new StringBuilder("");
			int diff = last - index - 1;
			if (last == words.size() || diff == 0) {
				for (int i = index; i < last; i++) {
					builder.append(words.get(i)).append(" ");
				}
				builder.deleteCharAt(builder.length() - 1);
				for (int i = builder.length(); i < L; i++) {
					builder.append(" ");
				}
			} else {
				int spaces = (L - count) / diff;
				int r = (L - count) % diff;
				for (int i = index; i < last; i++) {
					builder.append(words.get(i));
					if (i < last - 1) {
						for (int j = 0; j <= spaces + (i - index < r ? 1 : 0); j++) {
							builder.append(" ");
						}
					}
				}
			}
			lines.add(builder.toString());
			index = last;
		}
		return lines;
	}

	public static void main(String args[]) {
		ArrayList<String> input = new ArrayList<String>();
		input.add(0, "This");
		input.add(1, "is");
		input.add(2, "an");
		input.add(3, "example");
		input.add(4, "of");
		input.add(5, "text");
		input.add(6, "justification.");
		System.out.println(fullJustify(input, 16));
	}
}