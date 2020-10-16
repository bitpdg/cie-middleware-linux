package it.ipzs.carousel;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class carousel extends JPanel {

	private int index;
	private JButton btnRight;
	private JButton btnLeft;
	private List<JRadioButton> radioList;
	private List<Cie> cieList;
	private JPanel radioButtonPanel;
	private Map<String, Cie> cieDictionary;
	public CieCard cieLeft;
	public CieCard cieCenter;
	public CieCard cieRight;
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Map<String, Cie> cieDictionary;
					
					Cie cie1 = new Cie("Giovanni Muchacha", "CA123456AA");
					Cie cie2 = new Cie("Paolo Acampa", "CA654321AA");
					Cie cie3 = new Cie("Gennaro Stanzione", "CA246813AA");
					Cie cie4 = new Cie("Catello Cioffi", "CA9461325AA");
					Cie cie5 = new Cie("Vincenzo Bruscino", "CA5643126AA");

					
					cieDictionary = new HashMap<String, Cie>();
					
					cieDictionary.put("123456789", cie1);
					cieDictionary.put("987654321", cie2);
					
					
					cieDictionary.put("147258369", cie3);
					cieDictionary.put("963852741", cie4);
					cieDictionary.put("167315945", cie5);	
				
					
					carousel frame = new carousel();
					frame.configureCards(cieDictionary);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	public carousel()
	{
		//getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 59));
		setBackground(Color.WHITE);
		this.radioList = new ArrayList<>(30);
		
		index = 0;
		
		setBounds(200, -50, 600, 605);
		this.setLayout(null);
		
		cieLeft = new CieCard(CieCard.Size.CarouselSizeSmall);
		cieLeft.getLblIntestatario().setLocation(20, 128);
		cieLeft.getLblCardNumber().setLocation(20, 102);
		cieLeft.getLblNumberValue().setFont(new Font("Dialog", Font.PLAIN, 9));
		cieLeft.getLblName().setFont(new Font("Dialog", Font.PLAIN, 9));
		cieLeft.getLblName().setLocation(20, 140);
		cieLeft.getLblNumberValue().setLocation(20, 113);
		cieLeft.getLblCieImage().setSize(140, 86);
		cieLeft.setSize(150, 158);
		cieLeft.getLblCieImage().setLocation(5, 0);
		//cieLeft.getLblNumberValue().setSize(116, 15);
		//cieLeft.getLblName().setSize(116, 15);
		//cieLeft.getLblName().setLocation(29, 143);
		
	
		cieLeft.setLocation(38, 50);
			
		cieRight = new CieCard(CieCard.Size.CarouselSizeSmall);
		cieRight.getLblIntestatario().setLocation(20, 128);
		cieRight.getLblCardNumber().setLocation(20, 102);
		cieRight.getLblName().setFont(new Font("Dialog", Font.PLAIN, 9));
		cieRight.getLblName().setLocation(20, 140);
		cieRight.getLblNumberValue().setLocation(20, 113);
		cieRight.getLblCieImage().setSize(140, 86);
		cieRight.getLblCieImage().setLocation(5, 0);
		//cieRight.getLblNumberValue().setBounds(29, 129, 100, -16);
		//cieRight.getLblName().setSize(121, 15);
		//cieRight.getLblName().setLocation(29, 143);
		cieRight.setLocation(408, 50);
		
		cieCenter = new CieCard(CieCard.Size.CarouselSizeRegular);
		cieCenter.getLblIntestatario().setSize(111, 15);
		
		
		cieCenter.getLblCardNumber().setLocation(46, 170);
		cieCenter.getLblIntestatario().setLocation(35, 177);
		cieCenter.getLblCieImage().setSize(220, 120);
		cieCenter.getLblCieImage().setLocation(20, 11);
		
		cieCenter.getLblIntestatario().setFont(new Font("Tahoma", Font.PLAIN, 12));
		cieCenter.getLblCardNumber().setFont(new Font("Tahoma", Font.PLAIN, 12));
		cieCenter.getLblName().setFont(new Font("Tahoma", Font.BOLD, 14));
		cieCenter.getLblNumberValue().setFont(new Font("Tahoma", Font.BOLD, 14));
		cieCenter.getLblName().setSize(209, 25);
		cieCenter.getLblName().setLocation(30, 190);
		cieCenter.getLblIntestatario().setLocation(30, 177);
		cieCenter.getLblCieImage().setBounds(0, 0, 216, 138);
		cieCenter.setSize(216, 224);
		cieCenter.getLblNumberValue().setBounds(30, 151, 190, 25);
		cieCenter.getLblCardNumber().setBounds(30, 138, 111, 15);
		
		cieCenter.setLocation(191, 22);
				
		this.add(cieLeft);
		this.add(cieRight);
		this.add(cieCenter);	
		
		
		btnLeft = new JButton("");
		btnLeft.setIcon(new ImageIcon(carousel.class.getResource("/it/ipzs/cieid/res/back@2x.png")));
		btnLeft.setForeground(new Color(30, 144, 255));
		btnLeft.setFont(new Font("Dialog", Font.BOLD, 15));
		btnLeft.setBounds(-12, 150, 52, 48);
		btnLeft.setOpaque(false);
		btnLeft.setBorderPainted(false);
		btnLeft.setContentAreaFilled(false);
		
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				index--;
				
				if(index < 0)
				{
					index = cieList.size() - 1;
				}

				updateCards();
			}
		});
		
		this.add(btnLeft);
		
		btnRight = new JButton("");
		btnRight.setIcon(new ImageIcon(carousel.class.getResource("/it/ipzs/cieid/res/forward@2x.png")));
		btnRight.setForeground(new Color(30, 144, 255));
		btnRight.setFont(new Font("Dialog", Font.BOLD, 15));
		btnRight.setOpaque(false);
		btnRight.setBorderPainted(false);
		btnRight.setContentAreaFilled(false);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				radioList.get(index).doClick();
				index++;
				
				if(index >  cieList.size() - 1)
				{
					index = 0;
				}


				radioList.get(index).doClick();
				
				updateCards();
			}
			
		});
				
		btnRight.setBounds(548, 150, 52, 48);
		this.add(btnRight);
		
		radioButtonPanel = new JPanel();
		radioButtonPanel.setBackground(Color.WHITE);
		radioButtonPanel.setBounds(38, 258, 491, 25);
				
		this.add(radioButtonPanel);
	}
	
	public Cie getCardAtIndex()
	{
		return cieList.get(index);
	}
	
	public void configureRadios()
	{
		
		for(int i = 0; i<cieList.size(); i++)
		{
			JRadioButton newRadio = new JRadioButton();
			newRadio.setBackground(Color.WHITE);
			radioList.add(newRadio);
			radioButtonPanel.add(radioList.get(i));
			
			radioList.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					for(int i = 0; i<radioList.size(); i++)
					{
						if(e.getSource() == radioList.get(i))
						{
							index = i;
							radioList.get(i).setSelected(true);

							updateCards();
						}else 
						{
							radioList.get(i).setSelected(false);
						}
					}

				}	
			});
			
		}
		
			radioList.get(index).setSelected(true);
	}
	
	
	public void configureCards(Map<String, Cie> cieDictionary)
	{
				
		if(cieDictionary.size() == 0)
		{
			cieRight.setVisible(false);
			cieLeft.setVisible(false);
			cieCenter.setVisible(false);
			btnLeft.setVisible(false);
			btnRight.setVisible(false);
		}
		else if(cieDictionary.size() > 1)
		{
			cieRight.setVisible(true);
			cieLeft.setVisible(!(cieDictionary.size() == 2));
			cieCenter.setVisible(true);
			btnLeft.setVisible(!(cieDictionary.size() < 2));
			btnRight.setVisible(!(cieDictionary.size() == 2));
		}
		else if(cieDictionary.size() == 1)
		{
			cieRight.setVisible(false);
			cieLeft.setVisible(false);
			cieCenter.setVisible(true);
			btnLeft.setVisible(false);
			btnRight.setVisible(false);
		}
		
		this.cieList = new ArrayList<>(cieDictionary.values());
		
		configureRadios();
		
		if(cieList.size() > 0)
		{
			updateCards();
		}
	}
	
	
	private void updateRadioButtons()
	{
		if(cieList.size() == 0)
		{

			radioButtonPanel.setVisible(false);
			return;
		}
		
		radioList.removeAll(radioList);
		radioButtonPanel.removeAll();
		
		configureRadios();
		radioButtonPanel.revalidate();
		radioButtonPanel.repaint();
	}
	
	private void updateCards()
	{
		
		if(cieList.size() == 0)
		{
			cieCenter.setVisible(false);
			radioButtonPanel.setVisible(false);
			cieRight.setVisible(false);
			cieLeft.setVisible(false);
			btnLeft.setVisible(false);
			btnRight.setVisible(false);
			return;
		}
		
		if(index == cieList.size())
		{
			index = index -1;
		}
		
		int rightIndex = index + 1;
		int leftIndex = index - 1;
		
		if(rightIndex > (cieList.size() - 1))
		{
			rightIndex = 0;
		}
		
		
		if(leftIndex < 0)
		{
			leftIndex = (cieList.size() - 1);
		}
		
		cieLeft.configureCard(cieList.get(leftIndex));
		cieCenter.configureCard(cieList.get(index));
		cieRight.configureCard(cieList.get(rightIndex));
		
		if(cieList.size() == 2)
		{
			if(index == 0)
			{
				cieRight.setVisible(true);
				cieLeft.setVisible(false);
				btnLeft.setVisible(false);
				btnRight.setVisible(true);
			}else
			{
				cieRight.setVisible(false);
				cieLeft.setVisible(true);
				btnLeft.setVisible(true);
				btnRight.setVisible(false);
			}
		}else if(cieList.size() == 1)
		{
			cieRight.setVisible(false);
			cieLeft.setVisible(false);
			btnLeft.setVisible(false);
			btnRight.setVisible(false);
		}
		
		updateRadioButtons();
	}
}
