package com.patern.entity;

import java.util.List;
public class Guess{

	@Override
	public String toString() {
		return "Guess [checkbox=" + checkbox + ", input=" + input + ", radioGroup=" + radioGroup + ", slider=" + slider
				+ ", swith=" + swith + "]";
	}

	List<String> checkbox;
	String input;
 
	String radioGroup;
	 
	Double slider;
	 
	boolean swith;

	public List<String> getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(List<String> checkbox) {
		this.checkbox = checkbox;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getRadioGroup() {
		return radioGroup;
	}

	public void setRadioGroup(String radioGroup) {
		this.radioGroup = radioGroup;
	}

	public Double getSlider() {
		return slider;
	}

	public void setSlider(Double slider) {
		this.slider = slider;
	}

	public boolean isSwith() {
		return swith;
	}

	public void setSwith(boolean swith) {
		this.swith = swith;
	}
	
}
