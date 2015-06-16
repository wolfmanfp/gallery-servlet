<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bejelentkezés</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
    </head>
    <body>
        <header class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header navbar-left">
                    <img class="navbar-brand" src="logo.png" alt="Gallery">
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.jsp"><i class="fa fa-arrow-left"></i> Vissza</a></li>
                </ul>
            </div>
        </header>
        <div class="jumbotron jumbotron-form">
            <div class="container">
                <form class="gallery-form" role="form" method="post">
                    <fieldset>
                        <legend>Bejelentkezés</legend>
                        <div class="form-group col-md-12">
                            <label class="control-label" for="username">Felhasználónév:</label> 
                            <input class="form-control input-md" name="username" type="text">
                        </div>
                        <div class="form-group col-md-12">
                            <label class="control-label" for="password">Jelszó:</label> 
                            <input class="form-control input-md" name="password" type="password">
                        </div>
                        <div class="form-group col-md-12">
                            <button type="submit" class="btn btn-default btn-primary">Bejelentkezés</button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <footer class="navbar-static-bottom">
            <div class="container">
                <p class="navbar-text">Készítette: Farkas János (FAJTAAP.PTE), Farkas Péter (FAPVABP.PTE)</p>
            </div>
        </footer>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/js/bootstrap.min.js"></script>
    </body>
</html>