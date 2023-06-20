import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Tabletest {
    public  String process(List<String> list, int col){
        StringBuilder tableHtml = new StringBuilder();
        tableHtml.append("<table>");
        final AtomicInteger counter = new AtomicInteger();

        final Collection<List<String>> valuesByLine = list.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / col))
                .values();

        valuesByLine.stream()
                .forEach(line -> createLine(line, tableHtml));

        return tableHtml.append("<table>").toString();
    }

    public void createLine(List<String> listValueOfLine, StringBuilder html){
        html.append("<tr>");
        listValueOfLine.stream().forEach(valueLine -> html.append("<td>").append(valueLine).append("</td>"));
        html.append("</tr>");
    }
}
