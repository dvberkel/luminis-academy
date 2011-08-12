#! /usr/bin/env perl

use strict;
use warnings;

use FindBin '$Bin';
use lib "$Bin";

use Luminis::Academy qw(findGreatestSteppingStone nextSteppingStone);

print findGreatestSteppingStone(),"\n";
print nextSteppingStone(), "\n";
print nextSteppingStone(findGreatestSteppingStone()), "\n";