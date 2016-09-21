  
    var i = 0;

    function changeColor() {
    var elem = document.getElementById('num');
    elem.style.color = "red";
  }
   
   

    function plus() {
       
            document.getElementById('num').value = ++i;
    }
  
   
    function minus() {
        document.getElementById('num').value = --i;
    }

    
    function reset() {
        document.getElementById('num').value = 0;
    }

    




