package it.ipzs.pdfPreview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.ghost4j.document.DocumentException;
import org.ghost4j.document.PDFDocument;
import org.ghost4j.renderer.RendererException;
import org.ghost4j.renderer.SimpleRenderer;

public class PdfPreview {
    private JPanel prPanel;
    private String filePath;
    private String signImagePath;
    private int pdfPageIndex;
    private int pdfNumPages;
	private List<Image> images;			    
	private JLabel imgLabel;
    private ImageIcon imgIcon;
    private MoveablePicture signImage;
    private JPanel imgPanel;
    
    public PdfPreview(JPanel panelPdfPreview, String pdfFilePath, String signImagePath)
    {
    	this.prPanel = panelPdfPreview;
    	this.filePath = pdfFilePath;
    	this.signImagePath = signImagePath;
    	this.pdfPageIndex = 0;
    	imgIcon = new ImageIcon();
    	imgLabel = new JLabel();
    	imgPanel = new JPanel();
		imgPanel.setLayout(new BorderLayout(0,0));
		imgPanel.setBackground(Color.white);

		imgPanel.add(new MoveablePicture(signImagePath));
		imgPanel.add(imgLabel);
		
		try {
			PDFDocument document = new PDFDocument();
			document.load(new File(filePath));		
			pdfNumPages = document.getPageCount();
			System.out.println("Pdf page: " + pdfNumPages);
		    SimpleRenderer renderer = new SimpleRenderer();
		    
		    renderer.setResolution(100);
		    prPanel.removeAll();
			images = renderer.render(document);
			
			showPreview();

		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("PDF File not found");
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			System.out.println("Document Exception");
			e.printStackTrace();
		} catch (RendererException e) {
			// TODO Auto-generated catch block
			System.out.println("Renderer Exception");
			e.printStackTrace();
		}
    }
    
    private void showPreview()
    {
    	Image tmpImg = images.get(pdfPageIndex);
    	
    	int width = prPanel.getWidth();
    	int height = prPanel.getHeight();
    	
    	int tmpImgWidth = tmpImg.getWidth(null);
    	int tmpImgHeight =  tmpImg.getHeight(null);
    	
    	int imgHeigth = height;
    	int imgWidth = width;
    
    	if( tmpImgWidth > tmpImgHeight)
    	{
    		imgHeigth  = (int)(width*tmpImgHeight)/tmpImgWidth;
    		
    		if(imgHeigth > height)
    		{
    			imgWidth = (int)(height*tmpImgWidth)/tmpImgHeight;
				imgHeigth = (int)(imgWidth*tmpImgHeight)/tmpImgWidth;
    		}
    	}else
    	{
    		imgWidth = (int)(height*tmpImgWidth)/tmpImgHeight;
                    
            if(imgWidth > width)
            {
            	imgHeigth = (int)(width*imgHeigth)/tmpImgWidth;
        		imgWidth = (int)(imgHeigth*tmpImgWidth)/imgHeigth;
            }
    	}
    	
    	
		imgIcon.setImage(tmpImg.getScaledInstance(imgWidth, imgHeigth, Image.SCALE_AREA_AVERAGING));
		imgLabel.setIcon(imgIcon);
		imgLabel.setHorizontalAlignment(JLabel.CENTER);
		imgLabel.setVerticalAlignment(JLabel.CENTER);
	    imgLabel.revalidate();
	    imgLabel.repaint();
		
		//imgPanel.removeAll();
		imgPanel.setMaximumSize(new Dimension(imgWidth, imgHeigth));
		imgPanel.updateUI();
		
		prPanel.removeAll();
		prPanel.add(imgPanel);
		prPanel.updateUI();
    }
    
    public void prevImage()
    {
		if((pdfPageIndex -1) >= 0)
		{
			pdfPageIndex -= 1;
		}
		
		showPreview();
    }
    
    public void nextImage()
    {
		if((pdfPageIndex + 1) < pdfNumPages)
		{
			pdfPageIndex += 1;
		}
		
		showPreview();
    }
    
    
    private Map<String, Float> signImageInfos()
    {
    	return null;
    }
    
}
