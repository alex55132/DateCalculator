# DateCalculator
### Class made for calculate dates by the milliseconds
-----------------------
### Example use(getting a date and adding 1 year)
```java
        DateCalculator calc = new DateCalculator();
        
        long milliseconds = Long.parseLong("31536000000");
        
        Date newDate = calc.operateCustomDate(0, date, milliseconds);
        
        DateCalculator newCalc = new DateCalculator(newDate);
        
        System.out.println(newCalc.getCompleteDay());
```
