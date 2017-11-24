package fr.rzteam.DirectESport.mdparser;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;

import java.util.Arrays;

public class Markdown
{
    MutableDataSet options = null;
    Parser parser = null;
    HtmlRenderer renderer = null;        
            
    public Markdown()
    {
        options = new MutableDataSet();
        parser = Parser.builder(options).build();
        renderer = HtmlRenderer.builder(options).build();
    }
    
    public String parse(String markdown)
    {
        Node document = parser.parse(markdown);
        String html = renderer.render(document);
        System.out.println(html);
        return html;
    }
}