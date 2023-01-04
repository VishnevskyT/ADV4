package exercise_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Завдання 2
 * Напишіть жартівливу програму «Дешифратор», яка в текстовому файлі могла б замінити всі прийменники слово «Java».
 */

public class Decryptor {
    public static void main(String[] args) {

        try {
            File file = new File("C:\\Users\\LapTopUSA\\IdeaProjects\\ADV4\\src\\exercise_2\\text.txt");

            FileWriter fileWriter = new FileWriter(file);
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            fileWriter.write("""
                    Біля озера у літню ніч
                    Ми були з тобою віч-на-віч
                    Цілувались під зорями ми
                    Били лебеді поруч крильми
                    І несла понад світом луна
                    І у мене кохана одна
                    Хлюпотіла тихенько вода
                    Що для нас і біда - не біда
                    Цей сон, цей сон
                    Мені щоночі сниться
                    Крізь сон, крізь сон
                    Вона мені сміється
                    Цей сон, цей сон
                    Мене не покидає
                    Любов, о сон
                    Вона мене кохає.
                    Музика і виконання: Степан Гіга, вірш: Анатолій Фіглюк.""");

            fileWriter.flush();

            List<Pattern> prepositions = new ArrayList<>();

            prepositions.add(Pattern.compile(" без "));
            prepositions.add(Pattern.compile(" у "));
            prepositions.add(Pattern.compile(" в "));
            prepositions.add(Pattern.compile(" від "));
            prepositions.add(Pattern.compile(" для "));
            prepositions.add(Pattern.compile(" по "));
            prepositions.add(Pattern.compile(" через "));
            prepositions.add(Pattern.compile(" при "));
            prepositions.add(Pattern.compile(" про "));
            prepositions.add(Pattern.compile(" над "));
            prepositions.add(Pattern.compile(" під "));
            prepositions.add(Pattern.compile(" до "));
            prepositions.add(Pattern.compile(" з "));
            prepositions.add(Pattern.compile(" ради "));
            prepositions.add(Pattern.compile(" задля "));
            prepositions.add(Pattern.compile(" поруч "));
            prepositions.add(Pattern.compile(" крізь "));
            prepositions.add(Pattern.compile(" поза "));
            prepositions.add(Pattern.compile(" після "));
            prepositions.add(Pattern.compile(" близько "));
            prepositions.add(Pattern.compile(" біля "));
            prepositions.add(Pattern.compile(" понад "));

            String line;
            while ((line = fileReader.readLine()) != null) {
            line = " " + line + " ";

                for (Pattern preposition : prepositions) {
                    if (line.toLowerCase().contains(preposition.pattern().toLowerCase())) {
                        line = line.replaceAll(preposition.pattern(), " \u001B[34m" + "Java" + "\u001B[0m ");
                    }
                }
                System.out.println(line.trim());
                fileWriter.write("\n" + line.trim());
            }

            fileWriter.close();
            fileReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
