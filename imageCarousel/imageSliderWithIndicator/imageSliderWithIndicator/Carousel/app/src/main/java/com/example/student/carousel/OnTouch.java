public void onCheckedChanged(RadioGroup group, int checkedId)
{
     System.out.println(" imageFromRadioButton-i mej -------------- " +index);
     View radioButton = radioGroup.findViewById(checkedId);
     int i = radioGroup.indexOfChild(radioButton);
     
        if(i == 0)
        {
            System.out.println(" imageFromRadioButton-----------------  " +index);


            imgageView.setImageResource(images[i]);
            index = i;
        }
        else if(i == 1)
        {
            System.out.println(" imageFromRadioButton-----------------  " +index);


            imgageView.setImageResource(images[i]);
            index = i;
        }

        else if(i == 3)
        {
            System.out.println(" imageFromRadioButton-----------------  " +index);


            imgageView.setImageResource(images[getLenghtImages() - 2]);
            index = getLenghtImages() - 2;
        }
        else if(i == 4)
        {
            System.out.println(" imageFromRadioButton-----------------  " +index);


            imgageView.setImageResource(images[getLenghtImages() - 1]);
            index = getLenghtImages() - 1;
        }
        else
        {
            imgageView.setImageResource(images[getHalfOfLenghtImages()]);
            index = getHalfOfLenghtImages();

        }
}