  
 
    var number = 0;



    function changeColor(newColor) {
    var elem = document.getElementById('num');
    elem.style.color =  newColor;
  }

  function setColor()

  {

        if (number > 8)
        {
            
            document.getElementById('num').value = number;
            changeColor("red")
        }

        else
        {
             document.getElementById('num').value = number;
             changeColor("black")
        }
  }
   
   

    function plus() {
                                                                                                            
          ++number;
          setColor()
           
    }

  
   
    function minus() {

        --number;
        setColor()

    }

    
    function reset() {
        number = 0;  ;
        setColor();
    }

    




