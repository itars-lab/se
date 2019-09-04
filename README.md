
input[type='text'][name='email']              //has attributes
input[type^='te']                             //starts with
input[type$='xt']                             //ends with
input[name*='mai']                            //contains
input[name='password] + input[type='submit']  //the next element on the page
input[name='password] ~ input[type='submit']  //any of sibilings
div > input[name='emailConfirmation']         //direct decendant
form input[name='emailConfirmation']          //any decendant


div > #login > div > input.btn.btn-primary
#login > div:nth-child(1) > input.btn.btn-primary