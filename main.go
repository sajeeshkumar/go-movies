package main

import (
	"fmt"

	"github.com/sajeeshkumar/go-movies/services"
)

var appName = "movies-library"

func main() {
	fmt.Printf("Starting %v\n", appName)
	services.StartWebServer("6767")
}
