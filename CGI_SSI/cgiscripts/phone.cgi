#!/usr/bin/perl
my $rand = int(rand(100));
print "Set-Cookie: age=" . $rand . "\n";
print "Content-type: text/html\n\n";
system("java -cp /Users/kevinagary/work/asueast/classes/cst425/fall09/examples/cgi/classes edu.asupoly.cst425.PhoneCGI");
